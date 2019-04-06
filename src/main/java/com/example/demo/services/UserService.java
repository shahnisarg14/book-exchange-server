package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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



}
