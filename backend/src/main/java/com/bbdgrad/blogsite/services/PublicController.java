package com.bbdgrad.blogsite.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class PublicController {
    @GetMapping("/login")
    public void login(HttpServletResponse httpResponse) throws IOException {
        String loginURL = "https://blogsite.auth.eu-west-1.amazoncognito.com/login?client_id=mveo5kbuf4lrka1fnn13qm6s&response_type=code&scope=email+openid+phone&redirect_uri=http://localhost:8080/v1/landing";
        httpResponse.sendRedirect(loginURL);
    }

    @GetMapping("/landing")
    public String landing() {
        return "Hello, you";
    }

}
