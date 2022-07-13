package com.bbdgrad.blogsite.controllers;

import com.bbdgrad.blogsite.models.Blog;
import com.bbdgrad.blogsite.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class blogController {
    @Autowired
    private BlogRepository blogRepo;

    @GetMapping("/Blog/all")
    public ResponseEntity<Blog> getBlogData()
    {
        List<Blog> Blogs = blogRepo.findAll();
        return new ResponseEntity(Blogs, HttpStatus.OK);
    }


    @GetMapping("/Blog/Category/categoryName")
        public ResponseEntity<?> getBlogbyCategory(@RequestParam String categoryName)
        {
            if(blogRepo.findByCategoryCategoryName(categoryName).size() != 0)
            {
                return ResponseEntity.ok(blogRepo.findByCategoryCategoryName(categoryName));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    @GetMapping("/Blog/User/author")
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

    @PostMapping("Blog/new")
    public Blog addBlog(@RequestBody Blog newblog)
    {
        return blogRepo.save(newblog);
    }
}
