package com.example.demo.repository;

import com.example.demo.model.Posting;
import com.example.demo.model.Request;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RequestRepository extends CrudRepository<Request,Integer> {

    @Query("SELECT r from Request r WHERE username=:username")
    public List<Request> findRequestsByUserName(@Param("username") String username);

}
