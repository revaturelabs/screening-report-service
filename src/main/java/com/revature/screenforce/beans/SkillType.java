package com.revature.screenforce.beans;

//import java.util.Objects;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

/**
 *  The POJO for the SkillType
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */

//Hi Future Rex

public class SkillType  {


	private int skillTypeId;

	private String title;

    private boolean isActive;

	public int getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		result = prime * result + skillTypeId;
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
		SkillType other = (SkillType) obj;
		if (skillTypeId != other.skillTypeId)
			return false;
		return true;
	}

	public SkillType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillType(int skillTypeId, String title, boolean isActive) {
		super();
		this.skillTypeId = skillTypeId;
		this.title = title;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "SkillType [skillTypeId=" + skillTypeId + ", title=" + title + ", isActive=" + isActive + "]";
	}
  
    
    
}
