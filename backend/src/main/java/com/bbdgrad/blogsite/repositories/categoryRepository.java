package com.bbdgrad.blogsite.repositories;

import com.bbdgrad.blogsite.models.blog;
import com.bbdgrad.blogsite.models.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface categoryRepository extends JpaRepository<category, Long> {
    //List<category> findByName (String name);
}
