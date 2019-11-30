/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.crawler.controller;

import com.teso.story.crawler.model.author;
import com.teso.story.crawler.model.category;
import com.teso.story.crawler.model.category_story;
import com.teso.story.crawler.model.chapter;
import com.teso.story.crawler.model.story;
import com.teso.story.crawler.repository.authorRepository;
import com.teso.story.crawler.repository.categoryRepository;
import com.teso.story.crawler.repository.categoryStoryRepository;
import com.teso.story.crawler.repository.chapterRepository;
import com.teso.story.crawler.repository.storyRepository;
import com.teso.story.lib.TStoryCrawlerService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.TException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ASUS
 */
@Controller
public class CrawlerController implements TStoryCrawlerService.Iface {

    @Autowired
    storyRepository storyRepo;

    @Autowired
    chapterRepository chapterRepo;

    @Autowired
    categoryRepository categoryRepo;

    @Autowired
    authorRepository authorRepo;

    @Autowired
    categoryStoryRepository categoryStoryRepo;

    //Service cào tất cả danh mục CHẠY API NÀY TRƯỚC !!!
    @Override
    public boolean crawAllCategories() throws TException {
        Document doc;
        try {
            doc = Jsoup.connect("https://truyenfull.vn/").get();
            Elements categories = doc.select(".multi-column>.row>.col-md-4>.dropdown-menu li a");
            for (Element category : categories) {
                category _category = new category();
                System.out.println("category name : " + category.text());
                _category.setName(category.text());
                System.out.println("category link : " + category.attr("href"));
                _category.setLink(category.attr("href"));
                categoryRepo.save(_category);
            }
        } catch (IOException ex) {
            Logger.getLogger(CrawlerController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    //Service cào tất cả truyện 
    @Override
    public boolean crawAllStories() throws TException {
        try {
            int i = 1;
            Element glyphiconRight;
            Document doc;
            Elements stories;
            do {
                doc = Jsoup.connect("https://truyenfull.vn/danh-sach/truyen-full/trang-" + i).get();
                stories = doc.select("h3[itemprop=name] a[itemprop=url]");
                for (Element story : stories) {
                    story _story = new story();
                    System.out.println("Ten truyen : " + story.text());
                    _story.setName(story.text());
                    System.out.println("Link truyen : " + story.attr("href"));
                    _story.setLink(story.attr("href"));
                    author author = crawlAuthorOfStory(story.attr("href"));
                    _story.setAuthor(author);
                    Boolean isFull = crawlStatusOfStory(story.attr("href"));
                    _story.setIsFull(isFull);
                    Float rate = crawlAverageRating(story.attr("href"));
                    _story.setRate(rate);
                    storyRepo.save(_story);
                    _story.setCategories(crawlCategoriesOfStory(story.attr("href"), _story));
                    _story.setChapters(crawlAllChapterInStory(story.attr("href"), _story));
                }
                i++;
                glyphiconRight = doc.selectFirst("span.glyphicon-menu-right");
            } while (glyphiconRight != null);
        } catch (IOException ex) {
            Logger.getLogger(CrawlerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    //Cào tất cả chapter hiện có trong story
    private List<chapter> crawlAllChapterInStory(String url, story story) throws IOException {
        List<chapter> listChapters = new ArrayList<>();
        int i = 1;
        Element glyphiconRight;
        Document doc;
        Elements chapters;
        do {
            doc = Jsoup.connect(url + "trang-" + i + "/#list-chapter").get();
            chapters = doc.select("ul.list-chapter li a");
            for (Element chapter : chapters) {
                chapter _chapter = new chapter();
                System.out.println("Ten truyen : " + chapter.text());
                _chapter.setName(chapter.text());
                System.out.println("Link truyen : " + chapter.attr("href"));
                _chapter.setLink(chapter.attr("href"));
                _chapter.setStory(story);
                chapterRepo.save(_chapter);
                listChapters.add(_chapter);
            }
            i++;
            glyphiconRight = doc.selectFirst("span.glyphicon-menu-right");
        } while (glyphiconRight != null);
        return listChapters;
    }
    //Service cào danh mục của truyện 
    private List<category_story> crawlCategoriesOfStory(String url, story story) throws IOException {
        List<category_story> listCategoryStory = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements categories = doc.select(".info>div>a[itemprop=genre]");
        for (Element category : categories) {
            category_story categoryStory = new category_story();
            categoryStory.setCategoryS(categoryRepo.findCategoryByName(category.text()).get());
            categoryStory.setStoryC(story);
            categoryStoryRepo.save(categoryStory);
            listCategoryStory.add(categoryStory);
        }
        return listCategoryStory;
    }

    //Crawl trạng thái của truyện
    private Boolean crawlStatusOfStory(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element status = doc.selectFirst(".info>div>span.text-success");
        System.out.println("Status" + status);
        return status != null;
    }

    //Cào tác giả trong truyện
    private author crawlAuthorOfStory(String url) throws IOException {
        author author = new author();
        Document doc = Jsoup.connect(url).get();
        Element _author = doc.selectFirst(".info>div>a[itemprop=author]");
        System.out.println("author name : " + _author.text());
        author.setName(_author.text());
        if (authorRepo.findAuthorByName(author.getName()).isPresent()) {
            System.out.println("Da co tac gia ");
            return authorRepo.findAuthorByName(author.getName()).get();
        } else {
            System.out.println("chua co tac gia");
            authorRepo.save(author);
        }
        return author;
    }
    //Cào rating trong truyện
    private Float crawlAverageRating(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element rate = doc.selectFirst("span[property=v:average]");
        System.out.println("rate" + rate.text());
        return Float.parseFloat(rate.text());
    }
}
