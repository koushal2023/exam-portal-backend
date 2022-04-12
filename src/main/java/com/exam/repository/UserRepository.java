package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
public User findByUsername(String username);
public User findById(long id);
}
