package com.bbdgrad.blogsite.controllers;

import com.bbdgrad.blogsite.models.AwsUserDetails;
import com.bbdgrad.blogsite.models.DBUsers;
import com.bbdgrad.blogsite.models.JwtTokens;
import com.bbdgrad.blogsite.models.UserAccessInfo;
import com.bbdgrad.blogsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class PublicController {
    @Value("${cognito.loginUrl}")
    String cognitoLogin;

    @Value("${app.clientId}")
    String clientId;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/landing")
    public String landing() {
        return "landing";
    }

    @GetMapping("/token")
    public void getTokens(@RequestParam String code, HttpServletResponse httpResponse) throws IOException {
        String cognitoEndpoint = "https://blogsite.auth.eu-west-1.amazoncognito.com/oauth2";
        String redirectUrl = "";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "authorization_code");
        requestBody.add("client_id", clientId);
        requestBody.add("code", code);
        requestBody.add("redirect_uri", "https://bs-loadbalance-1072678543.af-south-1.elb.amazonaws.com/");

        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<JwtTokens> responseTokens = restTemplate.exchange(cognitoEndpoint + "/token", HttpMethod.POST, formEntity, JwtTokens.class);

        headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + responseTokens.getBody().getAccess_token());

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<AwsUserDetails> cognitoResponse = restTemplate.exchange(cognitoEndpoint + "/userInfo", HttpMethod.POST, entity, AwsUserDetails.class);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        responseHeaders.add("username", cognitoResponse.getBody().getUsername());
        responseHeaders.add("access_token", responseTokens.getBody().getAccess_token());
        responseHeaders.add("id_token", responseTokens.getBody().getId_token());
        responseHeaders.add("refresh_token", responseTokens.getBody().getRefresh_token());
        httpResponse.sendRedirect("http://localhost:4200/");
    }

    @PostMapping("/restricted")
        public String restricted(@RequestHeader Map<String, String> headers) {
        return "You now have access";
    }

    @GetMapping("/users")
    public ResponseEntity<List<DBUsers>> users() {
        List<DBUsers> users = userRepository.findAll();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        return new ResponseEntity<>(users, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/tokenAlt")
    public ResponseEntity<UserAccessInfo> getTokensAlt(@RequestParam String code, HttpServletResponse httpResponse, HttpServletRequest request) {
        String cognitoEndpoint = "https://blogsite.auth.eu-west-1.amazoncognito.com/oauth2";
        String redirectUrl = "";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "authorization_code");
        requestBody.add("client_id", clientId);
        requestBody.add("code", code);
        requestBody.add("redirect_uri", "https://bs-loadbalance-1072678543.af-south-1.elb.amazonaws.com/");

        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<JwtTokens> responseTokens = restTemplate.exchange(cognitoEndpoint + "/token", HttpMethod.POST, formEntity, JwtTokens.class);

        headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + responseTokens.getBody().getAccess_token());

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<AwsUserDetails> cognitoResponse = restTemplate.exchange(cognitoEndpoint + "/userInfo", HttpMethod.POST, entity, AwsUserDetails.class);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        responseHeaders.add("username", cognitoResponse.getBody().getUsername());

        return new ResponseEntity<>(new UserAccessInfo(cognitoResponse.getBody(), responseTokens.getBody()), responseHeaders, HttpStatus.OK);
    }
}
