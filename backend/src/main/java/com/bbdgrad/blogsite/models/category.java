package com.bbdgrad.blogsite.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "category")
@Entity
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryID;
    @Column(name = "categoryName")
    private String categoryName;
}
