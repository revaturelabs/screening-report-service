package com.revature.screenforce.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.revature.screenforce.beans.SoftSkillViolation;

@ApiModel(value = "Violation model", description = "A violation committed during a screening")
public class ViolationModel {

	@ApiModelProperty(value = "id of the violation")
	int violationId;

	@ApiModelProperty(value = "name of the violation")
	String violationName;

	@ApiModelProperty(value = "description of the violation")
	String violationDescription;

	@ApiModelProperty(value = "comment about the violation")
	String violationComment;

	public ViolationModel(SoftSkillViolation s) {
		this.violationComment = s.getComment();
		this.violationName = s.getViolationType().getViolationTypeText();
		this.violationId = s.getViolationType().getViolationTypeId();
		this.violationDescription = s.getViolationType().getDescription();
	}
	public ViolationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getViolationId() {
		return violationId;
	}

	public void setViolationId(int violationId) {
		this.violationId = violationId;
	}

	public String getViolationName() {
		return violationName;
	}

	public void setViolationName(String violationName) {
		this.violationName = violationName;
	}

	public String getViolationDescription() {
		return violationDescription;
	}

	public void setViolationDescription(String violationDescription) {
		this.violationDescription = violationDescription;
	}

	public String getViolationComment() {
		return violationComment;
	}

	public void setViolationComment(String violationComment) {
		this.violationComment = violationComment;
	}
	
}
