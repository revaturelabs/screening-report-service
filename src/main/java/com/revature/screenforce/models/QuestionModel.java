package com.revature.screenforce.models;

import com.revature.screenforce.beans.Question;

public class QuestionModel {
	// The internal ID of THIS question
	int questionId;
	// The Question
	String questionText;
	// The Answer
	String questionAnswer;
	// The Score Received
	Double score;
	String questionComment;

	public QuestionModel(Question q) {
		this.questionId = q.getQuestionId();
		this.questionText = q.getQuestionText();
		this.questionAnswer = q.getSampleAnswer();
	}

	public QuestionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getQuestionComment() {
		return questionComment;
	}

	public void setQuestionComment(String questionComment) {
		this.questionComment = questionComment;
	}

	@Override
	public String toString() {
		return "QuestionModel [questionId=" + questionId + ", questionText=" + questionText + ", questionAnswer="
				+ questionAnswer + ", score=" + score + ", questionComment=" + questionComment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + questionId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionModel other = (QuestionModel) obj;
		if (questionId != other.questionId)
			return false;
		return true;
	}

}
