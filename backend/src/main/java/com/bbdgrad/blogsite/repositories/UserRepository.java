package com.bbdgrad.blogsite.repositories;

import com.bbdgrad.blogsite.models.DBUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DBUsers, String> {

}
