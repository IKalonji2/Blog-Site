package com.bbdgrad.blogsite.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "[User]")
@Entity

public class User {
    @Id
    private String userid;
    private String name;
    private String surname;
    private String email_address;
    private String username;
    private int age;
    private String gender;
    private String biography;
}
