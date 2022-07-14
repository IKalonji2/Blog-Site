package com.bbdgrad.blogsite.controllers;

import com.bbdgrad.blogsite.models.Category;
import com.bbdgrad.blogsite.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class categoryController {

    @Autowired
    private CategoryRepository catRepo;
    @GetMapping("/categories")
    public ResponseEntity<Category> getAllCategories()
    {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return new ResponseEntity(catRepo.findAll(), responseHeaders, HttpStatus.OK);
    }
}
