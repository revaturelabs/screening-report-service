package com.revature.screenforce.beans;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//import java.util.Objects;

/**
 *  The POJO for the Question
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */

//Hi Future Rex
public class Question {

	private int questionId;
	private Bucket bucket;
	private boolean isActive;
	private String questionText;
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
		return "Question [questionId=" + questionId + ", bucket=" + bucket + ", isActive=" + isActive
				+ ", questionText=" + questionText + ", sampleAnswer=" + sampleAnswer + "]";
	}

	public Question(int questionId, Bucket bucket, boolean isActive, String questionText, String sampleAnswer) {
		super();
		this.questionId = questionId;
		this.bucket = bucket;
		this.isActive = isActive;
		this.questionText = questionText;
		this.sampleAnswer = sampleAnswer;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Bucket getBucket() {
		return bucket;
	}

	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
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
