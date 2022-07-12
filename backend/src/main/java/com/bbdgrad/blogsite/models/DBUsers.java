package com.bbdgrad.blogsite.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "[user]")
public class DBUsers {
    @Id
    private String userID;
    private String name;
    private String surname;
    private String email_address;
    private String username;
    private int age;
    private String gender;
    private String biography;
}
