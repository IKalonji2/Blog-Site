package com.bbdgrad.blogsite.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "Category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryID;
    @Column(name = "categoryName")
    private String categoryName;
}
