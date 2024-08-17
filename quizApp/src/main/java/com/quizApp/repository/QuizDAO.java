package com.quizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizApp.model.Quiz;

public interface QuizDAO extends JpaRepository<Quiz,Integer> {

}
