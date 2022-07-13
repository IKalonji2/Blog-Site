package com.bbdgrad.blogsite.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity health() throws IOException {
        return new ResponseEntity(HttpStatus.OK);
    }
}
