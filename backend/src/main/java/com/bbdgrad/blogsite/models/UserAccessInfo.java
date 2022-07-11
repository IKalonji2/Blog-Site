package com.bbdgrad.blogsite.models;

import lombok.Data;

@Data
public class UserAccessInfo {
    public AwsUserDetails awsUserDetails;
    public JwtTokens jwtTokens;

    public UserAccessInfo(AwsUserDetails awsUserDetails, JwtTokens jwtTokens) {
        this.awsUserDetails = awsUserDetails;
        this.jwtTokens = jwtTokens;
    }
}
