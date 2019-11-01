package com.revature.screenforce.models;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.revature.screenforce.beans.Category;

@ApiModel(value = "Category Model", description = "A Category which holds relevant category information")
public class CategoryModel {

	@ApiModelProperty(value = "id of the category")
    private int categoryId;

	@ApiModelProperty(value = "description of the category")
	private String categoryDescription;

	@ApiModelProperty(value = "holds the weight of the category")
	private int weightValue;

	@ApiModelProperty(value = "holds the average value of question scores")
    private double averageQuestionScore;

	@ApiModelProperty(value = "list of questions")
	private List<QuestionModel> question;
	
	public CategoryModel(Category c) {
		this.categoryId=c.getCategoryId();
		this.categoryDescription = c.getCategoryDescription();
	}
	
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoryModel [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription
				+ ", weightValue=" + weightValue + ", averageQuestionScore=" + averageQuestionScore + ", question="
				+ question + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
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
		CategoryModel other = (CategoryModel) obj;
		if (categoryId != other.categoryId)
			return false;
		return true;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public int getWeightValue() {
		return weightValue;
	}
	public void setWeightValue(int weightValue) {
		this.weightValue = weightValue;
	}
	public double getAverageQuestionScore() {
		return averageQuestionScore;
	}
	public void setAverageQuestionScore(double averageQuestionScore) {
		this.averageQuestionScore = averageQuestionScore;
	}
	public List<QuestionModel> getQuestion() {
		return question;
	}
	public void setQuestion(List<QuestionModel> question) {
		this.question = question;
	}
	
}
