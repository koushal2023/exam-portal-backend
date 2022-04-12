package com.exam.services;

import java.util.Set;

import com.exam.models.exam.Quiz;

public interface QuizService {
public Quiz addQuiz(Quiz quiz);
public Quiz updateQuiz(Quiz quiz);
public Set<Quiz> getAllQuiz();
public Quiz getQuizById(Long quizId);
public void deleteQuiz(Long quizId);
}
