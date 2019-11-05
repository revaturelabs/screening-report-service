package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The POJO for the ViolationType
 * 
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */

@ApiModel(value = "ViolationType", description = "contains information about a type of soft skill violation")
public class ViolationType {

	@ApiModelProperty(value = "the violation type id")
	private int violationTypeId;

	@ApiModelProperty(value = "the violation type name")
	private String violationTypeText;

	@ApiModelProperty(value = "the description of the violation type")
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
