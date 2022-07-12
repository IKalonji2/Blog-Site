package com.bbdgrad.blogsite.services;

import com.bbdgrad.blogsite.models.JwtTokens;
import com.bbdgrad.blogsite.models.UserAccessInfo;

import java.util.HashMap;
import java.util.Map;

public class LoginManager {
    private static LoginManager INSTANCE;
    private Map<String, JwtTokens> userDetails = new HashMap<>();

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new LoginManager();
        }
        return INSTANCE;
    }

    public JwtTokens getUserDetails(String sub) {
        JwtTokens userDetails = this.userDetails.remove(sub);
        if (userDetails != null) {
            System.out.println("Failed to retrieve");
        } else {
            System.out.println("Success");
        }
        return userDetails;
    }

    public void insertUserDetails(String sub, JwtTokens userTokens) {
        this.userDetails.put(sub, userTokens);
    }
}
