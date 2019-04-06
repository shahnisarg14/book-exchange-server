package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class UserService {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/api/login")
    public User login(@RequestBody User credentials,
                      HttpServletResponse response) {
        User fetchedUser = null;
        Iterable<User> users = userRepository.findUserByCredentials(credentials.getUsername(),
                credentials.getPassword());

        for (User user : users) {
            fetchedUser = user;
            break;
        }
        if(fetchedUser==null){
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
        return fetchedUser;
    }



}
