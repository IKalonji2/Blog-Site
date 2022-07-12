package com.bbdgrad.blogsite.services;

import com.bbdgrad.blogsite.models.UserAccessInfo;

import java.util.HashMap;
import java.util.Map;

public class LoginManager {
    private static LoginManager INSTANCE;
    private Map<String, UserAccessInfo> userDetails = new HashMap<>();

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new LoginManager();
        }
        return INSTANCE;
    }

    public UserAccessInfo getUserDetails(String sub) {
        return userDetails.remove(sub);
    }

    public void insertUserDetails(String sub, UserAccessInfo userDetails) {
        this.userDetails.put(sub, userDetails);
    }
}
