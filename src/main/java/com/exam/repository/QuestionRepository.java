package com.exam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.exam.Question;
import com.exam.models.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long>{
public Question findByQuesId(Long quesId);
public Set<Question> findByQuiz(Quiz quiz);
}
