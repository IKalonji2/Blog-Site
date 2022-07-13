package com.bbdgrad.blogsite.controllers;

import com.bbdgrad.blogsite.models.user;
import com.bbdgrad.blogsite.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class userController {
    @Autowired
    private userRepository userRepo;

    @GetMapping("/users")
    public ResponseEntity<List<user>> getusers()
    {
        List<user> users = userRepo.findAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}
