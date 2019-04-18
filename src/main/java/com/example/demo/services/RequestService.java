package com.example.demo.services;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class RequestService {


    @Autowired
    RequestRepository requestRepository;

    @GetMapping("/api/my-requests/{username}")
    public List<Request> getAllRequestsOfUser(@PathVariable("username") String username) {
        return requestRepository.findRequestsByUserName(username);
    }

    @PostMapping("/api/my-request")
    public Request createMyRequest(@RequestBody Request newRequest) {
        Request requestToBeAdded =new Request();
        if(newRequest.getDate()!=null){
            requestToBeAdded.setDate(newRequest.getDate());
        }
        if(newRequest.getPosting()!=null){
            requestToBeAdded.setpId(newRequest.getPosting().getpId());
        }
        if(newRequest.getUser()!=null){
            requestToBeAdded.setUsername(newRequest.getUser().getUsername());
        }

        requestRepository.save(requestToBeAdded);
        return newRequest;
    }



}
