/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.crawler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author ASUS
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class category_story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "story_id")
    story storyC;

    @ManyToOne
    @JoinColumn(name = "category_id")
    category categoryS;

    public category_story() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public story getStoryC() {
        return storyC;
    }

    public void setStoryC(story storyC) {
        this.storyC = storyC;
    }

    public category getCategoryS() {
        return categoryS;
    }

    public void setCategoryS(category categoryS) {
        this.categoryS = categoryS;
    }

    public category_story(Long id, story storyC, category categoryS) {
        this.id = id;
        this.storyC = storyC;
        this.categoryS = categoryS;
    }

}
