package com.bbdgrad.blogsite.controllers;

import com.bbdgrad.blogsite.models.Blog;
import com.bbdgrad.blogsite.models.Category;
import com.bbdgrad.blogsite.models.User;
import com.bbdgrad.blogsite.repositories.BlogRepository;
import com.bbdgrad.blogsite.repositories.CategoryRepository;
import com.bbdgrad.blogsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class userController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getusers()
    {
        List<User> users = userRepo.findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return new ResponseEntity<>(users, responseHeaders, HttpStatus.OK);
    }
}
