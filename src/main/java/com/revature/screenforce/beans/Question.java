package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The POJO for the Question 
 * 
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */

@ApiModel(value = "Question", description = "a Question which may be asked during a Screening")
public class Question {

	@ApiModelProperty(value = "id of the question")
	private int questionId;

	@ApiModelProperty(value = "Category to which the question belongs")
	private Category category;

	@ApiModelProperty(value = "whether the question is active")
	private boolean isActive;

	@ApiModelProperty(value = "the text of the question")
	private String questionText;

	@ApiModelProperty(value = "a sample of the answer to the question")
	private String sampleAnswer;

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
		Question other = (Question) obj;
		if (questionId != other.questionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", category=" + category + ", isActive=" + isActive
				+ ", questionText=" + questionText + ", sampleAnswer=" + sampleAnswer + "]";
	}

	public Question(int questionId, Category category, boolean isActive, String questionText, String sampleAnswer) {
		super();
		this.questionId = questionId;
		this.category = category;
		this.isActive = isActive;
		this.questionText = questionText;
		this.sampleAnswer = sampleAnswer;
	}

	public Question() {
		super();
	}

	public int getQuestionId() {
		return questionId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getSampleAnswer() {
		return sampleAnswer;
	}

	public void setSampleAnswer(String sampleAnswer) {
		this.sampleAnswer = sampleAnswer;
	}

}
