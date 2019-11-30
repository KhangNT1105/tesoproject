/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.crawler.repository;

import com.teso.story.crawler.model.author;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface authorRepository extends JpaRepository<author, Long> {

    @Query(value = "SELECT * FROM author a WHERE a.name = ?1", nativeQuery = true)
    Optional<author> findAuthorByName(String name);
}
