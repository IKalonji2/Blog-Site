package com.bbdgrad.blogsite.models;

import lombok.Data;

@Data
public class JwtTokens {
    public String id_token;
    public String access_token;
    public String refresh_token;
    public int expires_in;
    public String token_type;
}
