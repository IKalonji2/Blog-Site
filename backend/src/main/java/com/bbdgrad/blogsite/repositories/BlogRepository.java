package com.bbdgrad.blogsite.repositories;

import com.bbdgrad.blogsite.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByCategoryCategoryName(String categoryName);
    List<Blog> findByUserUsername(String username);
}
