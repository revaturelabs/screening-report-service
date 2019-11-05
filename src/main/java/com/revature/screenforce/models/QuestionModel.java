package com.revature.screenforce.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.revature.screenforce.beans.Question;

@ApiModel(value = "Candidate model", description = "A Full report which holds relevant screening information")
public class QuestionModel {


	@ApiModelProperty(value = "id of the question")
	int questionId;

	@ApiModelProperty(value = "id of the question")
	String questionText;

	@ApiModelProperty(value = "answer of the question")
	String questionAnswer;

	@ApiModelProperty(value = "score received for the question")
	Double score;

	@ApiModelProperty(value = "screener comment for question")
	String questionComment;

	public QuestionModel(Question q) {
		this.questionId = q.getQuestionId();
		this.questionText = q.getQuestionText();
		this.questionAnswer = q.getSampleAnswer();
	}

	public QuestionModel() {
		super();
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
