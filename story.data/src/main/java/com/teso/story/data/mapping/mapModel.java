/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.data.mapping;

import com.teso.story.data.model.author;
import com.teso.story.data.model.category;
import com.teso.story.data.model.story;
import com.teso.story.lib.authorLib;
import com.teso.story.lib.categoryLib;
import com.teso.story.lib.storyLib;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class mapModel {

    public static story mapStory(story story, storyLib storyLib) {
        story.setId(storyLib.getId());
        story.setName(storyLib.getName());
        story.setLink(storyLib.getLink());
        story.setRate(storyLib.getRate());
        story.setIsFull(storyLib.isFull);
        story.setAuthor(mapAuthor(story.getAuthor(), storyLib.getAuthor()));
        return story;
    }

    public static author mapAuthor(author author, authorLib authorLib) {
        author.setId(authorLib.getId());
        author.setName(authorLib.getName());
        return author;
    }

    public static category mapCategory(category category, categoryLib categoryLib) {
        category.setId(categoryLib.getId());
        category.setName(categoryLib.getName());
        category.setLink(categoryLib.getLink());
        return category;
    }
}
