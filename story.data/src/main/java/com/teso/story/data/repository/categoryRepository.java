/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.data.repository;

import com.teso.story.data.model.category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface categoryRepository extends JpaRepository<category, Long> {
    @Query(value = "SELECT * FROM category c WHERE c.name= ?1",nativeQuery = true)
    Optional<category> findCategoryByName(String name);
}
