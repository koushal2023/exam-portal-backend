package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
public Quiz findByQid(Long qid);
}
