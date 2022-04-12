package com.exam.services;

import java.util.Set;

import com.exam.models.exam.Question;
import com.exam.models.exam.Quiz;

public interface QuestionService {
public Question addQuestion(Question question);
public Question updateQuestion(Question question);
public Set<Question> getAllQuestions();
public Question getQuestionById(Long questionId);
public void deleteQuestion(Long questionId);
public Set<Question> getQuestionsOfQuiz(Quiz quiz);
}
