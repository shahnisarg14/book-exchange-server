package com.example.demo.services;

import com.example.demo.model.Posting;
import com.example.demo.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

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

    @GetMapping("api/my-postings/{username}")
    public List<Posting> getAllPostingsOfUser(@PathVariable("username") String username) {
        return postingRepository.findPostsByUserName(username);
    }

    @PostMapping("/api/my-posting")
    public Posting createMyPosting(@RequestBody Posting newMyPosting){
        postingRepository.save(newMyPosting);
        return newMyPosting;
    }


}
