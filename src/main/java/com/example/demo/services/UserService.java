package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class UserService {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/register")
    public User register(@RequestBody User user, HttpServletResponse response) {
        Iterable<User> users = userRepository.findUserByUserName(user.getUsername());
        User fetchedUser = null;
        for (User u : users) {
            fetchedUser = user;
            break;
        }

        if (fetchedUser != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return fetchedUser;
        } else {
            return userRepository.save(user);
        }
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

    @GetMapping("/api/profile/{username}")
    public User profile(@PathVariable("username") String username,
                        HttpServletResponse response){
        User fetchUser = null;
        Iterable<User> users = userRepository.findUserByUserName(username);
        for (User user : users) {
            fetchUser = user;
            break;
        }

        return fetchUser;
    }

    @PutMapping("/api/user")
    public User updateUser(@RequestBody User newUser){
        Iterable<User> data = userRepository.findUserByUserName(newUser.getUsername());
        for(User user: data) {
            user.setfirstName(newUser.getfirstName());
            user.setlastName(newUser.getlastName());
            user.setCellNumber(newUser.getCellNumber());
            user.setPassword(newUser.getPassword());
            user.setEmailId(newUser.getEmailId());
            userRepository.save(user);
            return user;
        }
        return null;
    }

    @PostMapping("/api/logout")
    public HttpServletResponse logout(HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        return response;

    }

}
