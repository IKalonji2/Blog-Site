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
        return userDetails.remove(sub);
    }

    public void insertUserDetails(String sub, JwtTokens userTokens) {
        this.userDetails.put(sub, userTokens);
    }
}
