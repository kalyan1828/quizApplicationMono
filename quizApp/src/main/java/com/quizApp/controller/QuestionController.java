package com.quizApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quizApp.model.Questions;
import com.quizApp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Questions>>getAllQuestios() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{cat}")
	public ResponseEntity<List<Questions>> getAllQuestionsByCategory(@PathVariable("cat") String category){
		return questionService.getAllQuestionsByCAtegory(category);
		
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Questions questions) {
		
		return questionService.addQuestion(questions);	
	}
}
