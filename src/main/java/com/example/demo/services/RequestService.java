package com.example.demo.services;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
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

    @GetMapping("/api/requests")
    public List<Request> getAllRequests() {
        List<Request> requestList = new ArrayList<>();
        Iterator<Request> iterator=  requestRepository.findAll().iterator();
        while(iterator.hasNext()) {
            requestList.add(iterator.next());
        }
        return  requestList;

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


    @DeleteMapping("/api/request/{pId}")
    public List<Request> deletePosting(@PathVariable("pId") int pId) {
        Iterator<Request> iterator=  requestRepository.findAll().iterator();
        List<Request> requestList = new ArrayList<>();
        while(iterator.hasNext()) {
            Request r = iterator.next();
            if(r.getpId()==pId){
                requestRepository.delete(r);
            }else{
                requestList.add(r);
            }
        }
        return  requestList;
    }



}
