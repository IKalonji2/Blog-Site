package com.bbdgrad.blogsite.controllers;

import com.bbdgrad.blogsite.models.Blog;
import com.bbdgrad.blogsite.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<List<Blog>> getBlogData()
    {
        List<Blog> Blogs = blogRepo.findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return new ResponseEntity<>(Blogs, responseHeaders, HttpStatus.OK);
    }


    @GetMapping("/Blog/Category/categoryName")
        public ResponseEntity<?> getBlogbyCategory(@RequestParam String categoryName)
        {
            if(blogRepo.findByCategoryCategoryName(categoryName).size() != 0)
            {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.add("Access-Control-Allow-Origin", "*");
                responseHeaders.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

                return new ResponseEntity<>(blogRepo.findByCategoryCategoryName(categoryName), responseHeaders, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    @GetMapping("/Blog/User/author")
        public ResponseEntity<?> getBlogByUserName(@RequestParam String userName)
        {
            if (blogRepo.findByUserUsername(userName).size() != 0)
            {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.add("Access-Control-Allow-Origin", "*");
                responseHeaders.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
                return new ResponseEntity<>(blogRepo.findByUserUsername(userName), responseHeaders, HttpStatus.OK);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }

    @PostMapping("Blog/new")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog newblog)
    {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        Blog blog = blogRepo.save(newblog);
        return new ResponseEntity<>(blog, responseHeaders, HttpStatus.OK);
    }
}
