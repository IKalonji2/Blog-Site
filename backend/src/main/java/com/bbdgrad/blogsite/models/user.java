package com.bbdgrad.blogsite.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "[user]")
@Entity

public class user {
    @Id
    private String userID;
    private String name;
    private String surname;
    private String email_address;
    private String username;
    private int age;
    private String gender;
    private String Biography;


}
