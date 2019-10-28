package com.revature.screenforce.beans;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
import java.util.Date;
//import java.util.Objects;

/**
 *  The POJO for the QuestionScore
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
public class QuestionScore {

	private int questionScoreId;
	private int questionId;
	private int bucketId;
	private Screening screening;
	private Double score;
	private String comment;
	private Date beginTime;
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + questionScoreId;
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
		QuestionScore other = (QuestionScore) obj;
		if (questionScoreId != other.questionScoreId)
			return false;
		return true;
	}
	public QuestionScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionScore(int questionScoreId, int questionId, int bucketId, Screening screening, Double score,
			String comment, Date beginTime) {
		super();
		this.questionScoreId = questionScoreId;
		this.questionId = questionId;
		this.bucketId = bucketId;
		this.screening = screening;
		this.score = score;
		this.comment = comment;
		this.beginTime = beginTime;
	}
	@Override
	public String toString() {
		return "QuestionScore [questionScoreId=" + questionScoreId + ", questionId=" + questionId + ", bucketId="
				+ bucketId + ", screening=" + screening + ", score=" + score + ", comment=" + comment + ", beginTime="
				+ beginTime + "]";
	}
	public int getQuestionScoreId() {
		return questionScoreId;
	}
	public void setQuestionScoreId(int questionScoreId) {
		this.questionScoreId = questionScoreId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getBucketId() {
		return bucketId;
	}
	public void setBucketId(int bucketId) {
		this.bucketId = bucketId;
	}
	public Screening getScreening() {
		return screening;
	}
	public void setScreening(Screening screening) {
		this.screening = screening;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	
	
}
