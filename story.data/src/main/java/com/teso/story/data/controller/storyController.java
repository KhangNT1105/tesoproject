/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.data.controller;

import com.teso.story.data.mapping.mapModel;
import com.teso.story.data.model.author;
import com.teso.story.data.model.category;
import com.teso.story.data.model.chapter;
import com.teso.story.data.model.story;
import com.teso.story.data.repository.authorRepository;
import com.teso.story.data.repository.categoryRepository;
import com.teso.story.data.repository.chapterRepository;
import com.teso.story.data.repository.storyRepository;
import com.teso.story.data.util.responseUtil;
import com.teso.story.lib.TStoryDataService;
import com.teso.story.lib.authorLib;
import java.util.List;
import java.util.Optional;
import org.apache.thrift.TException;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

/**
 *
 * @author ASUS
 */
@Controller
public class storyController implements TStoryDataService.Iface {

    @Autowired
    storyRepository storyRepo;
    @Autowired
    categoryRepository categoryRepo;
    @Autowired
    authorRepository authorRepo;
    @Autowired
    chapterRepository chapterRepo;


    private static final DozerBeanMapper dozerMapper = new DozerBeanMapper();

    //Service lấy tất cả truyện
    @Override
    public String getAllStories() throws TException {
        List<story> listStories = storyRepo.findAll();
        if (listStories.isEmpty()) {
            return responseUtil.notFound();
        }
        return responseUtil.success(responseUtil.responseListStory(listStories));
    }

    //Service lấy tất cả  danh mục
    @Override
    public String getAllCategories() {
        List<category> listCategories = categoryRepo.findAll();
        if (listCategories.isEmpty()) {
            return responseUtil.notFound();
        }
        return responseUtil.success(responseUtil.responseListCategory(listCategories));
    }

    //Service lấy truyện theo tên
    @Override
    public String getStoryByName(String name) throws TException {
        if (StringUtils.isEmpty(name)) {
            return responseUtil.invalid();
        } else {
            List<story> story = storyRepo.findStoryByName(name);
            if (!story.isEmpty()) {
                return responseUtil.success(responseUtil.responseListStory(story));
            }
            return responseUtil.notFound();
        }
    }

    //Service lấy truyện theo tác giả
    @Override
    public String getStoryByAuthorId(long authorId) throws TException {
        Optional<author> author = authorRepo.findById(authorId);
        if (author.isPresent()) {
            return responseUtil.success(responseUtil.responseListStoryOfAuthor(author.get().getStories()));
        }
        return responseUtil.notFound();
    }

    //Service lấy truyện theo id
    @Override
    public String getStoryById(long id) throws TException {
        Optional<story> story = storyRepo.findById(id);
        if (story.isPresent()) {
            return responseUtil.success(responseUtil.responseStory(story.get()));
        }
        return responseUtil.notFound();

    }

    //Service lấy truyện phân trang
    @Override
    public String getStoryByPageable(int itemPerPage, int pageNumber) throws TException {
        return responseUtil.success(responseUtil.responseListStory(storyRepo.findStoryByPageable(itemPerPage, pageNumber)));

    }

    //Service lấy chapter theo truyện phân trang(truyền vào id truyện,số lượng chapter trên 1 trang,trang thứ mấy)
    @Override
    public String getChapterStoryByPageable(long storyId, int itemPerPage, int pageNumber) throws TException {
        Optional<story> story = storyRepo.findById(storyId);
        if (story.isPresent()) {
            List<chapter> listChapters = chapterRepo.getChapterStoryByPageable(itemPerPage * (pageNumber - 1), itemPerPage
            );
            story.get().setChapters(listChapters);
            return responseUtil.success(responseUtil.responseStory(story.get()));
        } else {
            return responseUtil.notFound();
        }
    }

    //Service lấy những truyện có lượt rating cao nhất (Truyền vào số lượng truyện muốn lấy)
    @Override
    public String getQuantityStoryWithHighestRating(int quantity) throws TException {
        return responseUtil.success(responseUtil.responseListStory(storyRepo.getQuantityStoryWithHighestRating(quantity)));
    }

    //Service lấy những truyện có lượt rating thấp nhất (Truyền vào số lượng truyện muốn lấy)
    @Override
    public String getQuantityStoryWithLowestRating(int quantity) throws TException {
        return responseUtil.success(responseUtil.responseListStory(storyRepo.getQuantityStoryWithLowestRating(quantity)));
    }

    //Service lấy tổng số phân trang chapter của story (truyền vào id truyện , số lượng chapter trên 1 trang )
    @Override
    public String getTotalPaginationStory(long storyId, int itemPerPage) throws TException {

        Optional<story> story = storyRepo.findById(storyId);
        if (story.isPresent()) {
            Double totalChapter = chapterRepo.countChapterByStoryId(storyId);
            Double totalPagination = Math.ceil(totalChapter / itemPerPage);
            return responseUtil.success(responseUtil.responseTotalPagination(totalPagination));
        }

        return responseUtil.notFound();
    }

    @Override
    public String postAuthor(authorLib authorLib) throws TException {
        author author = new author();
        author = mapModel.mapAuthor(author, authorLib);
        authorRepo.save(author);
        return "successs";
    }

}
