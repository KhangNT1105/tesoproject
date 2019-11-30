/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.data.repository;

import com.teso.story.data.model.author;
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
public interface authorRepository extends JpaRepository<author, Long> {

    @Query(value = "SELECT * FROM author a WHERE a.name like %?1%", nativeQuery = true)
    List<author> findAuthorByName(String name);

    @Query(value = "SELECT * FROM author a WHERE a.id= ?1", nativeQuery = true)
    public Optional<author> findAllById(long id);

    public Optional<author> findAuthorById(long id);
}
