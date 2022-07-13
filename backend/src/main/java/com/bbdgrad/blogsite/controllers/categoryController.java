package com.bbdgrad.blogsite.controllers;

import com.amazonaws.Response;
import com.bbdgrad.blogsite.models.category;
import com.bbdgrad.blogsite.repositories.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class categoryController {

    @Autowired
    private categoryRepository catRepo;
    @GetMapping("/categories")
    public ResponseEntity<category> getAllCategories()
    {
        return new ResponseEntity(catRepo.findAll(), HttpStatus.OK);
    }
}
