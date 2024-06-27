package com.main.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.studentManagement.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
}

