package com.exam.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.models.exam.Question;
import com.exam.models.exam.Quiz;
import com.exam.services.QuestionService;
import com.exam.services.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

// adding questions
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(questionService.addQuestion(question));
	}

//	updating question
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(questionService.updateQuestion(question));
	}

//	getting n number of quesiton of the quiz which we have provided via qid not all the questions
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid) {
//		this will return all of the quesitons but we want question less than or equals to the max numberOfQuestions
//		Quiz quiz = new Quiz();
//		quiz.setQid(qid);
//		return ResponseEntity.ok(questionService.getQuestionsOfQuiz(quiz));

//		for that we use this code
		Quiz quiz = quizService.getQuizById(qid);
		Set<Question> questions = quiz.getQuestion();
		List list = new ArrayList(questions);
		if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}

//	getting all quesiton of the quiz
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid) {
//			this will return all of the quesitons but we want question less than or equals to the max numberOfQuestions
			Quiz quiz = new Quiz();
			quiz.setQid(qid);
			return ResponseEntity.ok(questionService.getQuestionsOfQuiz(quiz));

	}

//	get single question
	@GetMapping("/{quesId}")
	public ResponseEntity<Question> getQuestionById(@PathVariable("quesId") Long quesId) {
		return ResponseEntity.ok(questionService.getQuestionById(quesId));
	}

//	delete question
	@DeleteMapping("/{quesId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable("quesId") Long quesId) {
		questionService.deleteQuestion(quesId);
		return ResponseEntity.ok("question deleted successfully");
	}
}
