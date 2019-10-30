package com.revature.screenforce.beans;

/**
 *  The POJO for the bucket
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */


public class Category {

    private int categoryId;
    private String categoryDescription;
    private boolean isActive;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int categoryId, String categoryDescription, boolean isActive) {
		super();
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription + ", isActive="
				+ isActive + "]";
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		return true;
	}
  
 
  
}

