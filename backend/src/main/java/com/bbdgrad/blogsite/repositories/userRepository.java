package com.bbdgrad.blogsite.repositories;


import com.bbdgrad.blogsite.models.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user,String> {
}
