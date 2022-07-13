package com.bbdgrad.blogsite.models;

import lombok.Data;

@Data
public class AwsUserDetails {
        public String sub;
        public String email_verified;
        public String email;
        public String username;
}
