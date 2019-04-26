package com.revature.screenforce.models;

import java.util.List;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.beans.QuestionScore;

public class QuestionModel {
	private Bucket bucket;
	private boolean isActive;
	private String questionText;
	private String sampleAnswer1;
	private String sampleAnswer2;
	private String sampleAnswer3;
	private String sampleAnswer4;
	private String sampleAnswer5;
	private List<QuestionScore> questionScores;
	
	public QuestionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QuestionModel(Bucket bucket, boolean isActive, String questionText, String sampleAnswer1,
			String sampleAnswer2, String sampleAnswer3, String sampleAnswer4, String sampleAnswer5,
			List<QuestionScore> questionScores) {
		super();
		this.bucket = bucket;
		this.isActive = isActive;
		this.questionText = questionText;
		this.sampleAnswer1 = sampleAnswer1;
		this.sampleAnswer2 = sampleAnswer2;
		this.sampleAnswer3 = sampleAnswer3;
		this.sampleAnswer4 = sampleAnswer4;
		this.sampleAnswer5 = sampleAnswer5;
		this.questionScores = questionScores;
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
	public String getSampleAnswer1() {
		return sampleAnswer1;
	}
	public void setSampleAnswer1(String sampleAnswer1) {
		this.sampleAnswer1 = sampleAnswer1;
	}
	public String getSampleAnswer2() {
		return sampleAnswer2;
	}
	public void setSampleAnswer2(String sampleAnswer2) {
		this.sampleAnswer2 = sampleAnswer2;
	}
	public String getSampleAnswer3() {
		return sampleAnswer3;
	}
	public void setSampleAnswer3(String sampleAnswer3) {
		this.sampleAnswer3 = sampleAnswer3;
	}
	public String getSampleAnswer4() {
		return sampleAnswer4;
	}
	public void setSampleAnswer4(String sampleAnswer4) {
		this.sampleAnswer4 = sampleAnswer4;
	}
	public String getSampleAnswer5() {
		return sampleAnswer5;
	}
	public void setSampleAnswer5(String sampleAnswer5) {
		this.sampleAnswer5 = sampleAnswer5;
	}
	public List<QuestionScore> getQuestionScores() {
		return questionScores;
	}
	public void setQuestionScores(List<QuestionScore> questionScores) {
		this.questionScores = questionScores;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bucket == null) ? 0 : bucket.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((questionScores == null) ? 0 : questionScores.hashCode());
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		result = prime * result + ((sampleAnswer1 == null) ? 0 : sampleAnswer1.hashCode());
		result = prime * result + ((sampleAnswer2 == null) ? 0 : sampleAnswer2.hashCode());
		result = prime * result + ((sampleAnswer3 == null) ? 0 : sampleAnswer3.hashCode());
		result = prime * result + ((sampleAnswer4 == null) ? 0 : sampleAnswer4.hashCode());
		result = prime * result + ((sampleAnswer5 == null) ? 0 : sampleAnswer5.hashCode());
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
		if (bucket == null) {
			if (other.bucket != null)
				return false;
		} else if (!bucket.equals(other.bucket))
			return false;
		if (isActive != other.isActive)
			return false;
		if (questionScores == null) {
			if (other.questionScores != null)
				return false;
		} else if (!questionScores.equals(other.questionScores))
			return false;
		if (questionText == null) {
			if (other.questionText != null)
				return false;
		} else if (!questionText.equals(other.questionText))
			return false;
		if (sampleAnswer1 == null) {
			if (other.sampleAnswer1 != null)
				return false;
		} else if (!sampleAnswer1.equals(other.sampleAnswer1))
			return false;
		if (sampleAnswer2 == null) {
			if (other.sampleAnswer2 != null)
				return false;
		} else if (!sampleAnswer2.equals(other.sampleAnswer2))
			return false;
		if (sampleAnswer3 == null) {
			if (other.sampleAnswer3 != null)
				return false;
		} else if (!sampleAnswer3.equals(other.sampleAnswer3))
			return false;
		if (sampleAnswer4 == null) {
			if (other.sampleAnswer4 != null)
				return false;
		} else if (!sampleAnswer4.equals(other.sampleAnswer4))
			return false;
		if (sampleAnswer5 == null) {
			if (other.sampleAnswer5 != null)
				return false;
		} else if (!sampleAnswer5.equals(other.sampleAnswer5))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "QuestionModel [bucket=" + bucket + ", isActive=" + isActive + ", questionText=" + questionText
				+ ", sampleAnswer1=" + sampleAnswer1 + ", sampleAnswer2=" + sampleAnswer2 + ", sampleAnswer3="
				+ sampleAnswer3 + ", sampleAnswer4=" + sampleAnswer4 + ", sampleAnswer5=" + sampleAnswer5
				+ ", questionScores=" + questionScores + "]";
	}
	
	
}
