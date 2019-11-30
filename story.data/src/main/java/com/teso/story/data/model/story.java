/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "story")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"})
public class story implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String link;

    @Column(name = "isFull", nullable = false, columnDefinition = "bool default 0")
    private Boolean isFull;

    private Double rate;

    public story(Long id, String name, String link, Boolean isFull, Double rate, author author) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.isFull = isFull;
        this.rate = rate;
        this.author = author;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Boolean getIsFull() {
        return isFull;
    }

    public void setIsFull(Boolean isFull) {
        this.isFull = isFull;
    }

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @OneToMany(mappedBy = "story")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<chapter> chapters = new ArrayList<>();

    @OneToMany(mappedBy = "storyC")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<category_story> categories = new ArrayList<>();

    @ManyToOne(optional = false)
    author author;

    public author getAuthor() {
        return author;
    }

    public void setAuthor(author author) {
        this.author = author;
    }

    public List<category_story> getCategories() {
        return categories;
    }

    public void setCategories(List<category_story> categories) {
        this.categories = categories;
    }

    public List<chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<chapter> chapters) {
        this.chapters = chapters;
    }

    public story() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public story(Long id, String name, String link, Boolean isFull, Double rate) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.isFull = isFull;
        this.rate = rate;
    }

    public void getIsFull(boolean full) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
