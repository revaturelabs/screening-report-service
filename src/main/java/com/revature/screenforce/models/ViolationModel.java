package com.revature.screenforce.models;

import com.revature.screenforce.beans.SoftSkillViolation;

public class ViolationModel {
	int violationId;
	String violationName;
	String violationDescription;
	String violationComment;

	public ViolationModel(SoftSkillViolation s) {
		this.violationComment = s.getComment();
		this.violationName = s.getViolationType().getViolationTypeText();
		this.violationId = s.getViolationType().getViolationTypeId();
		this.violationDescription = s.getViolationType().getDescription();
	}

	public ViolationModel() {
		super();
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
