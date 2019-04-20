package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.Posting;
import com.example.demo.model.WishList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishListRepository extends CrudRepository<WishList, Integer> {
}
