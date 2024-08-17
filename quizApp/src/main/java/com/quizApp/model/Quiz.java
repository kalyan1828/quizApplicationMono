package com.quizApp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@ManyToMany
	private List<Questions> questions;
	
	public Quiz(Integer id, String title, List<Questions> questions) {
		super();
		this.id = id;
		this.title = title;
		this.questions = questions;
	}
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	
	
}
