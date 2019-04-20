package com.example.demo.services;

import com.example.demo.model.Book;
import com.example.demo.model.Posting;
import com.example.demo.model.User;
import com.example.demo.model.WishList;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/wishlist")
    public WishList createWishlist(@RequestBody WishList wishlist){
        wishListRepository.save(wishlist);
        return wishlist;
    }

    @PostMapping("/api/my-wishlist/{wId}")
    public WishList addToWishlist(@PathVariable("wId") int wId, @RequestBody Book book){
        Optional<WishList> wishlist = wishListRepository.findById(wId);
        WishList w = wishlist.get();
        Set<Book> set = w.getBooks();
        if (!set.contains(book)) {
            set.add(book);
        }
        wishListRepository.save(w);
        return w;
    }

    @GetMapping("/api/my-wishlist/{username}")
    public WishList findWishlistById(@PathVariable("username") String username) {
        Iterable<User> users = userRepository.findUserByUserName(username);
        User fetchedUser = null;
        for (User u : users) {
            fetchedUser = u;
            break;
        }
        return fetchedUser.getWishList();
    }

    @GetMapping("/api/books/{wId}")
    public Set<Book> getAllBooks(@PathVariable("wId") int wId) {
        Optional<WishList> wishlist = wishListRepository.findById(wId);
        WishList w = wishlist.get();
        return w.getBooks();
    }
}
