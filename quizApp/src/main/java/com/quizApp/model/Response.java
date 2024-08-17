package com.quizApp.model;

public class Response {
	
	private Integer id;
	private String res;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public Response(Integer id, String res) {
		super();
		this.id = id;
		this.res = res;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
