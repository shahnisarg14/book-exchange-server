package com.example.demo.services;

import com.example.demo.model.Posting;
import com.example.demo.model.WishList;
import com.example.demo.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @PostMapping("/api/wishlist")
    public WishList createWishlist(@RequestBody WishList wishlist){
        wishListRepository.save(wishlist);
        return wishlist;
    }
}
