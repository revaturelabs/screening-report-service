package com.revature.screenforce.models;

import com.revature.screenforce.beans.Question;

public class QuestionModel {
	//The internal ID of THIS question
	int QuestionId;
	//The Question
	String QuestionText;
	//The Answer
	String QuestionAnswer;
	//The Score Received
	Double Score;
	String QuestionComment;
	
	
	public QuestionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QuestionModel(Question q) {
		this.QuestionId = q.getQuestionId();
		this.QuestionText = q.getQuestionText();
		this.QuestionAnswer = q.getSampleAnswer();
	}
	
	public int getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}
	public String getQuestionText() {
		return QuestionText;
	}
	public void setQuestionText(String questionText) {
		QuestionText = questionText;
	}
	public String getQuestionAnswer() {
		return QuestionAnswer;
	}
	public void setQuestionAnswer(String questionAnswer) {
		QuestionAnswer = questionAnswer;
	}
	public Double getScore() {
		return Score;
	}
	public void setScore(Double score) {
		Score = score;
	}
	public String getQuestionComment() {
		return QuestionComment;
	}
	public void setQuestionComment(String questionComment) {
		QuestionComment = questionComment;
	}
	
	
}

