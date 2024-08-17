package com.quizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizApp.model.QuestionWrapper;
import com.quizApp.model.Questions;
import com.quizApp.model.Quiz;
import com.quizApp.model.Response;
import com.quizApp.repository.QuestionDAO;
import com.quizApp.repository.QuizDAO;

@Service
public class QuizService {

	@Autowired
	QuizDAO quizDAo;
	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Questions> questions=questionDAO.findRandomQuestionsByCategory(category,numQ);
		Quiz quiz= new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDAo.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz=quizDAo.findById(id);
		List<Questions> questionsFromDB=quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser=new ArrayList<>();
		
		for(Questions q:questionsFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
		Quiz quiz= quizDAo.findById(id).get();
		List<Questions>questions=quiz.getQuestions();
		int i=0,right=0;
		for(Response responses:response) {
			if(responses.getRes().equals(questions.get(i).getRightAnswer())) {
			right++;
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
}
