package com.bbdgrad.blogsite.controllers;

import com.bbdgrad.blogsite.models.blog;
import com.bbdgrad.blogsite.models.category;
import com.bbdgrad.blogsite.models.user;
import com.bbdgrad.blogsite.repositories.blogRepository;
import com.bbdgrad.blogsite.repositories.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class blogController {
    @Autowired
    private blogRepository blogRepo;

    @GetMapping("/blog/all")
    public ResponseEntity<blog> getBlogData()
    {
        List<blog> blogs = blogRepo.findAll();
        return new ResponseEntity(blogs, HttpStatus.OK);
    }


    @GetMapping("/blog/category/categoryName")
        public ResponseEntity<?> getBlogbyCategory(@RequestParam String categoryName)
        {
            if(blogRepo.findByCategoryCategoryName(categoryName).size() != 0)
            {
                return ResponseEntity.ok(blogRepo.findByCategoryCategoryName(categoryName));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    @GetMapping("/blog/user/author")
        public ResponseEntity<?> getBlogByUserName(@RequestParam String userName)
        {
            if (blogRepo.findByUserName(userName).size() != 0)
            {
                return ResponseEntity.ok(blogRepo.findByUserName(userName));
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }

    @PostMapping("blog/new")
    public blog addBlog(@RequestBody blog newblog)
    {
        return blogRepo.save(newblog);
    }




}
