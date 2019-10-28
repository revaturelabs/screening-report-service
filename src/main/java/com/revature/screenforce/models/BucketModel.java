package com.revature.screenforce.models;


import java.util.List;

import com.revature.screenforce.beans.Bucket;

public class BucketModel {
	int bucketId;
	//The name of this bucket
	String bucketName;
	//The score the Candidate recieved on this bucket
	int weightVaule;
	//A list of all the Questions Asked relating to THIS bucket
	List<QuestionModel> questionAsked;
	//skill type number to the name
	//composite score
	
	public BucketModel() {
		super();
	}
	public BucketModel(Bucket b) {
		this.bucketName = b.getBucketDescription();
		this.bucketId = b.getBucketId();
	}
	
	
	
	public int getBucketId() {
		return bucketId;
	}
	public void setBucketId(int bucketId) {
		this.bucketId = bucketId;
	}
	public String getBucketName() {
		return bucketName;
	}
	
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public int getWeightVaule() {
		return weightVaule;
	}
	public void setWeightVaule(int weightVaule) {
		this.weightVaule = weightVaule;
	}
	public List<QuestionModel> getQuestionAsked() {
		return questionAsked;
	}
	public void setQuestionAsked(List<QuestionModel> questionAsked) {
		this.questionAsked = questionAsked;
	}
	

}
