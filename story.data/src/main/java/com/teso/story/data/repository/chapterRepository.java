/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.data.repository;

import com.teso.story.data.model.chapter;
import com.teso.story.data.model.story;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface chapterRepository extends JpaRepository<chapter, Long> {

    @Query(value = "SELECT COUNT(id) FROM chapter c WHERE c.story_id=?1", nativeQuery = true)
    Double countChapterByStoryId(Long id);

    @Query(value = "SELECT * FROM chapter c WHERE c.story_id LIMIT ?1 , ?2 ", nativeQuery = true)
    List<chapter> getChapterStoryByPageable(Integer from, Integer to);
}
