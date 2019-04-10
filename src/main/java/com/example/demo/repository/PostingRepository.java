package com.example.demo.repository;

import com.example.demo.model.Posting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Iterator;
import java.util.List;

public interface PostingRepository extends CrudRepository<Posting,Integer> {
    @Query("SELECT p from Posting p WHERE username=:username")
    public List<Posting> findPostsByUserName(@Param("username") String username);

}
