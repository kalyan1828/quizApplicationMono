package com.quizApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quizApp.model.Questions;

public interface QuestionDAO extends JpaRepository<Questions, Integer> {

	List<Questions> getByCategory(String category);

	@Query(value="select * from questions q where q.category=:category order by RAND() Limit :numQ",nativeQuery=true)
	List<Questions> findRandomQuestionsByCategory(String category, int numQ);
	

}
