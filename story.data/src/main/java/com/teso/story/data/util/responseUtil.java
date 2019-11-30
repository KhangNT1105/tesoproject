/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.data.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.teso.story.data.constants.statusCode;
import com.teso.story.data.model.author;
import com.teso.story.data.model.category;
import com.teso.story.data.model.category_story;
import com.teso.story.data.model.chapter;
import com.teso.story.data.model.story;
import com.teso.story.lib.authorLib;
import com.teso.story.lib.storyLib;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.dozer.DozerBeanMapper;
import org.springframework.util.StringUtils;

/**
 *
 * @author ASUS
 */
public class responseUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static DozerBeanMapper dozerMapper = new DozerBeanMapper();

    @JsonIgnore
    public static ObjectNode responseStory(story story) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("id", story.getId());
        objectNode.put("name", story.getName());
        objectNode.put("link", story.getLink());
        objectNode.put("rate", story.getRate());
        objectNode.put("status", story.getIsFull() ? "Full" : "Đang ra");
        objectNode.set("author", responseAuthorOfStory(story.getAuthor()));
        //truyền số lượng chapter hiển thị
        objectNode.set("chapters", responseListChapter(story.getChapters(), 10));
        objectNode.set("categories", responseListCategoriesOfStory(story.getCategories()));
        return objectNode;
    }

    public static ArrayNode responseListStory(List<story> stories) {
        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (story story : stories) {
            arrayNode.add(responseStory(story));
        }
        return arrayNode;
    }

    public static ObjectNode responseChapter(chapter chapter) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", chapter.getName());
        return objectNode;
    }

    public static ArrayNode responseListChapter(List<chapter> chapters, int quantity) {
        ArrayNode arrayNode = objectMapper.createArrayNode();
        if (chapters.size() > quantity) {
            for (int i = 0; i < quantity; i++) {
                arrayNode.add(responseChapter(chapters.get(i)));
            }
        } else {
            chapters.forEach((item) -> {
                arrayNode.add(responseChapter(item));
            });
        }
        return arrayNode;
    }

    public static ObjectNode responseCategory(category category) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("id", category.getId());
        objectNode.put("name", category.getName());
        objectNode.put("link", category.getLink());
        return objectNode;
    }

    public static ArrayNode responseListCategory(List<category> categories) {
        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (category category : categories) {
            arrayNode.add(responseCategory(category));
        }
        return arrayNode;
    }

    public static ObjectNode responseCategoryOfStory(category_story categoryStory) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", categoryStory.getCategoryS().getName());
        return objectNode;
    }

    @JsonIgnore
    public static ArrayNode responseListCategoriesOfStory(List<category_story> listCategoryStory) {
        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (category_story categoryStory : listCategoryStory) {
            arrayNode.add(responseCategoryOfStory(categoryStory));
        }
        return arrayNode;
    }

    public static ObjectNode responseAuthorOfStory(author author) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", author.getName());
        return objectNode;
    }

    public static ObjectNode responseAuthor(author author) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("id", author.getId());
        objectNode.put("name", author.getName());
        objectNode.set("stories", responseListStoryOfAuthor(author.getStories()));
        return objectNode;
    }

    public static ObjectNode responseStoryOfAuthor(story story) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("id", story.getId());
        objectNode.put("name", story.getName());
        return objectNode;
    }

    public static ArrayNode responseListStoryOfAuthor(List<story> stories) {
        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (story story : stories) {
            arrayNode.add(responseStoryOfAuthor(story));
        }
        return arrayNode;
    }

    public static ObjectNode responseTotalPagination(Double total) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("total", total);
        return objectNode;
    }

    public static ArrayNode responseListAuthor(List<author> listAuthor) {
        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (author author : listAuthor) {
            arrayNode.add(responseAuthor(author));
        }
        return arrayNode;
    }

    public static String success(JsonNode body) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put(statusCode.class.getSimpleName(), statusCode.SUCCESS.getValue());
        objectNode.put("message", statusCode.SUCCESS.name());
        objectNode.set("response", body);
        return objectNode.toString();
    }

    public static String invalid() {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put(statusCode.class.getSimpleName(), statusCode.PARAMETER_INVALID.getValue());
        objectNode.put("message", statusCode.PARAMETER_INVALID.name());
        objectNode.put("response", "");
        return objectNode.toString();
    }

    public static String notFound() {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put(statusCode.class.getSimpleName(), statusCode.NOT_FOUND.getValue());
        objectNode.put("message", statusCode.NOT_FOUND.name());
        objectNode.put("response", "");
        return objectNode.toString();
    }

}
