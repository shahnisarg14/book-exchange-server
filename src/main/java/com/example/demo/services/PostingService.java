package com.example.demo.services;

import com.example.demo.model.Book;
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

    @GetMapping("/api/my-posting/{pId}")
    public Posting getPostingById(@PathVariable("pId") int pId) {
        Optional<Posting> posting = postingRepository.findById(pId);
        if (posting.isPresent())  return posting.get();
        else throw new NoSuchElementException();
    }

    @PostMapping("/api/my-posting")
    public Posting createMyPosting(@RequestBody Posting newMyPosting){
        postingRepository.save(newMyPosting);
        return newMyPosting;
    }

    @PutMapping("/api/posting/{pId}")
    public Posting updatePosting(@PathVariable("pId") int pId,@RequestBody Posting updatedPosting) {
        Optional<Posting> posting = postingRepository.findById(pId);
        if(posting.isPresent())
        {
            Posting oldPosting = posting.get();
            oldPosting.setBook(updatedPosting.getBook());
            postingRepository.save(oldPosting);
            return oldPosting;
        }
        return null;
    }

    @DeleteMapping("/api/posting/{pId}")
    public List<Posting> deletePosting(@PathVariable("pId") int pId) {
        postingRepository.deleteById(pId);
        return getAllPostingsOfUser(getPostingById(pId).getUser().getUsername());
    }
}
