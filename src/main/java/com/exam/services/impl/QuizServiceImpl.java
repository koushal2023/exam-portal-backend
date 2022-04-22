package com.exam.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.models.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getAllQuiz() {
		return new LinkedHashSet<>(quizRepository.findAll());
	}

	@Override
	public Quiz getQuizById(Long quizId) {
		return quizRepository.findByQid(quizId);
	}

	@Override
	public void deleteQuiz(Long quizId) {
		quizRepository.deleteById(quizId);

	}

	@Override
	public Set<Quiz> getAllQuizByCategoryId(Long cid) {
		return quizRepository.findByCategoryCid(cid);
	}

	@Override
	public Set<Quiz> getAllActiveQuiz() {
		return new LinkedHashSet<>(quizRepository.getAllActiveQuizzes());
	}

	@Override
	public Quiz getActiveQuizById(Long quizId) {
		return quizRepository.getByQid(quizId);
	}

	@Override
	public Set<Quiz> getAllActiveQuizByCategoryId(Long cid) {
		return quizRepository.getByCategoryCid(cid);
	}

}
