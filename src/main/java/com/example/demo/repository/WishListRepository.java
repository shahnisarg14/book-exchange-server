package com.example.demo.repository;

import com.example.demo.model.WishList;
import org.springframework.data.repository.CrudRepository;

public interface WishListRepository extends CrudRepository<WishList, Integer> {
}
