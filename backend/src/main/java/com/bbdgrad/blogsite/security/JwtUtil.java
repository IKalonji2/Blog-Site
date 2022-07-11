package com.bbdgrad.blogsite.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Base64;

public class JwtUtil {
    public String decodeUsername(String token) throws JsonProcessingException {
        //TODO: Get info from JWT Token
//        String[] chunks = token.split(" ")[1].split("\\.");
//        Base64.Decoder decoder = Base64.getUrlDecoder();
//        String payload = new String(decoder.decode(chunks[1]));
//        ObjectMapper mapper = new ObjectMapper();
//        UserDetails user = mapper.readValue(payload, UserDetails.class);
//        return user.getUsername();
        return null;
    }
}
