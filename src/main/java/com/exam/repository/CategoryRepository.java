package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
public Category findByTitle(String title);
public Category findByCid(Long cid);
}
