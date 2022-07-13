package com.bbdgrad.blogsite.repositories;


import com.bbdgrad.blogsite.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
