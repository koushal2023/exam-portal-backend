package com.exam.controllers;

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

import com.exam.models.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;
import com.exam.services.impl.QuizServiceImpl;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;
//	adding quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
		Quiz qiz = quizService.addQuiz(quiz);
		return ResponseEntity.ok(qiz);
	}
	
//	updating quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(quizService.updateQuiz(quiz));
	}
	
//	getting all the quizzes
	@GetMapping("/")
	public ResponseEntity<?> getAllQuizzes(){
		return ResponseEntity.ok(quizService.getAllQuiz());
	}
	
//	get single quiz
	@GetMapping("/{qid}")
	public ResponseEntity<?> getQuiz(@PathVariable("qid") Long qid){
		return ResponseEntity.ok(quizService.getQuizById(qid));
	}
	
//	delete quiz
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable("qid") Long qid){
		quizService.deleteQuiz(qid);
	}
}
