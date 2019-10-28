package com.revature.screenforce.beans;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//import javax.persistence.*;
//import java.util.Objects;
/**
 *  The POJO for the ViolationType
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
//Hi Future Rex
public class ViolationType {

	private int violationTypeId;

	private String violationTypeText;

	
	private String description;
	
	
	public ViolationType() {
		super();
	}

	public ViolationType(int violationTypeId, String violationTypeText, String description) {
		super();
		this.violationTypeId = violationTypeId;
		this.violationTypeText = violationTypeText;
		this.description = description;
	}


	public int getViolationTypeId() {
		return violationTypeId;
	}

	public void setViolationTypeId(int violationTypeId) {
		this.violationTypeId = violationTypeId;
	}

	public String getViolationTypeText() {
		return violationTypeText;
	}

	public void setViolationTypeText(String violationTypeText) {
		this.violationTypeText = violationTypeText;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + violationTypeId;
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
		ViolationType other = (ViolationType) obj;
		if (violationTypeId != other.violationTypeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ViolationType [violationTypeId=" + violationTypeId + ", violationTypeText=" + violationTypeText
				+ ", description=" + description + "]";
	}

}
