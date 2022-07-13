package com.bbdgrad.blogsite.repositories;

import com.bbdgrad.blogsite.models.blog;
import com.bbdgrad.blogsite.models.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface blogRepository extends JpaRepository<blog, Long> {
    List<blog> findByCategoryCategoryName(String categoryName);
    List<blog> findByUserName(String name);


}
