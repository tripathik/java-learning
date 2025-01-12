package com.javalearning.webapp.repository;

import com.javalearning.webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
}
