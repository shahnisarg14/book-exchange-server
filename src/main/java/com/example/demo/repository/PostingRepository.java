package com.example.demo.repository;

import com.example.demo.model.Posting;
import org.springframework.data.repository.CrudRepository;

public interface PostingRepository extends CrudRepository<Posting,Integer> {

}
