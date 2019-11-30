/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.data.repository;

import com.teso.story.data.model.author;
import com.teso.story.data.model.story;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface storyRepository extends JpaRepository<story, Long> {

    @Query(value = "SELECT * FROM story s WHERE s.name LIKE %?%1", nativeQuery = true)
    List<story> findStoryByName(String name);

    @Query(value = "SELECT * FROM story s WHERE s.author_id = ?1", nativeQuery = true)
    List<story> findStoryByAuthor(Long id);

    @Query(value = "SELECT * FROM story s LIMIT ?1 , ?2 ", nativeQuery = true)
    List<story> findStoryByPageable(Integer itemPerPage, Integer pageNumber);

    @Query(value = "SELECT * FROM story s ORDER BY s.rate DESC LIMIT 0,?1 ", nativeQuery = true)
    List<story> getQuantityStoryWithHighestRating(int quantity);

    @Query(value = "SELECT * FROM story s ORDER BY s.rate ASC LIMIT 0,?1 ", nativeQuery = true)
    List<story> getQuantityStoryWithLowestRating(int quantity);
}
