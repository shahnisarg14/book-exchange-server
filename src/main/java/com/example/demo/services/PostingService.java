package com.example.demo.services;

import com.example.demo.model.Posting;
import com.example.demo.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class PostingService {

    @Autowired
    PostingRepository postingRepository;

    @GetMapping("/api/postings")
    public List<Posting> getAllPostings() {
        Iterator<Posting> iterator = postingRepository.findAll().iterator();

        List<Posting> list = new ArrayList<>();
        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
        return  list;
    }
}
