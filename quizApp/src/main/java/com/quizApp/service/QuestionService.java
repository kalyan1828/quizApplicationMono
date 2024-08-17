package com.quizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizApp.model.Questions;
import com.quizApp.repository.QuestionDAO;

@Service
public class QuestionService {
	@Autowired
	QuestionDAO questionDAO;
	
	public ResponseEntity<List<Questions>> getAllQuestions() {
		
		try{
			return new ResponseEntity<>(questionDAO.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Questions>> getAllQuestionsByCAtegory(String category) {
		try {
		return new ResponseEntity<>(questionDAO.getByCategory(category),HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Questions questions) {
		try {
		questionDAO.save(questions);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("sucess",HttpStatus.CREATED);
	}

}
