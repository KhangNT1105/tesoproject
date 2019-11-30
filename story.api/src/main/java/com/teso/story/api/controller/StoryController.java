/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.api.controller;

import com.teso.story.api.config.StoryCrawlerClient;
import com.teso.story.api.config.StoryDataClient;
import com.teso.story.api.util.responseUtil;
import com.teso.story.lib.authorLib;
import com.teso.story.lib.storyLib;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
public class StoryController {

    @Autowired
    StoryDataClient client_data;
    @Autowired
    StoryCrawlerClient client_crawler;

    //Crawl tất cả danh mục CHẠY API NÀY TRƯỚC KHI CRAWL TRUYỆN
    @GetMapping(value = "/crawlallcategories")
    public boolean crawlAllCategories() throws TException {
        return client_crawler.crawAllCategories();
    }

    //Crawl tất cả truyên
    @GetMapping(value = "/crawlallstories")
    public boolean crawlAllStories() throws TException {
        return client_crawler.crawAllStories();
    }

    //Lấy tất cả truyện
    @GetMapping(value = "/getallstories", produces = "application/json")
    public String getAllStories() throws TException {
        return client_data.getAllStories();
    }

    //Lấy tất cả các danh mục truyện
    @GetMapping(value = "/getallcategories", produces = "application/json")
    public String getAllCateroies() throws TException {
        return client_data.getAllCategories();
    }

    //Lấy truyện từ tên (lấy tất cả truyện có param name)
    //Vd : name :"Anh"=> [Anh yêu em nhất , Anh nhớ em, Anh chàng đẹp trai]
    @GetMapping(value = "/getstorybyname", produces = "appication/json")
    public String getStoryByName(HttpServletRequest request) throws TException {
        String name = request.getParameter("name");
        return client_data.getStoryByName(name);
    }

    //Lấy truyện từ tác gỉa
    @GetMapping(value = "/getstorybyauthorid", produces = "application/json")
    public String getStoryByAuthorId(HttpServletRequest request) throws TException {
        try {
            Long authorId = Long.parseLong(request.getParameter("authorId"));
            return client_data.getStoryByAuthorId(authorId);
        } catch (Exception e) {
            return responseUtil.invalid();
        }
    }

    //Lấy truyện từ id
    @GetMapping(value = "/getstorybyid", produces = "application/json")
    public String getStoryById(HttpServletRequest request) throws TException {
        try {
            long id = Long.parseLong(request.getParameter("id"));
            return client_data.getStoryById(id);

        } catch (Exception e) {
            return responseUtil.invalid();
        }
    }

    //Lấy truyện từ phân trang (nhập vào số lượng truyện trên 1 trang và trang mấy)
    @GetMapping(value = "/getstorybypageable", produces = "application/json")
    public String getStoryByPageable(HttpServletRequest request) throws TException {
        try {
            Integer itemPerPage = Integer.parseInt(request.getParameter("itemPerPage"));
            Integer pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            return client_data.getStoryByPageable(itemPerPage, pageNumber);
        } catch (Exception e) {
            return responseUtil.invalid();
        }
    }

    //Lấy chapter của truyện (nhập vào id truyện , số lượng truyện trên 1 trang và trang mấy)
    @GetMapping(value = "/getchapterstorybypageable", produces = "application/json")
    public String getChapterStoryByPageable(HttpServletRequest request) throws TException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            Integer itemPerPage = Integer.parseInt(request.getParameter("itemPerPage"));
            Integer pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            return client_data.getChapterStoryByPageable(id, itemPerPage, pageNumber);
        } catch (Exception e) {
            return responseUtil.invalid();
        }
    }

    //Lấy số lượng truyện đạt rating cao nhất (Nhập vào số lượng truyện)
    @GetMapping(value = "/getquantitystorywithhighestrating", produces = "application/json")
    public String getQuantityStoryWithHighestRating(HttpServletRequest request) throws TException {
        try {
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            return client_data.getQuantityStoryWithHighestRating(quantity);
        } catch (Exception e) {
            return responseUtil.invalid();
        }
    }

    //Lấy số lượng truyện đạt rating thấp nhất (Nhập vào số lượng truyện)
    @GetMapping(value = "/getquantitystorywithlowestrating", produces = "application/json")
    public String getQuantityStoryWithLowestRating(HttpServletRequest request) throws TException {
        try {
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            return client_data.getQuantityStoryWithLowestRating(quantity);
        } catch (Exception e) {
            return responseUtil.invalid();
        }

    }

    //Trả về tổng số phân trang (Nhập vào id truyện, số lượng chapter trên 1 trang)
    @GetMapping(value = "/gettotalpaginationstory", produces = "application/json")
    public String getTotalPaginationStory(HttpServletRequest request) throws TException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            Integer itemPerPage = Integer.parseInt(request.getParameter("itemPerPage"));
            return client_data.getTotalPaginationStory(id, itemPerPage);
        } catch (Exception e) {
            return responseUtil.invalid();
        }
    }


    //Tạo author mới
    @PostMapping(value = "/postauthor", produces = "application/json")
    public String postAuthor(@Valid @RequestBody authorLib authorLib) throws TException {
        return client_data.postAuthor(authorLib);
    }

}
