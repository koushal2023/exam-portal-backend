package com.exam.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.models.exam.Question;
import com.exam.models.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.services.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Set<Question> getAllQuestions() {
		return new LinkedHashSet<>(questionRepository.findAll());
	}

	@Override
	public Question getQuestionById(Long questionId) {
		return questionRepository.findByQuesId(questionId);
	}

	@Override
	public void deleteQuestion(Long questionId) {
		questionRepository.deleteById(questionId);
		
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		return questionRepository.findByQuiz(quiz);
	}

}
