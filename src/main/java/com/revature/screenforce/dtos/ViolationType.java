package com.revature.screenforce.dtos;

import java.util.Objects;


//5/27 JU - body from screening application

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ViolationType that = (ViolationType) o;
		return getViolationTypeId() == that.getViolationTypeId() &&
				Objects.equals(getViolationTypeText(), that.getViolationTypeText()) &&
				Objects.equals(getDescription(), that.getDescription());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getViolationTypeId(), getViolationTypeText(), getDescription());
	}

	@Override
	public String toString() {
		return "ViolationType{" +
				"violationTypeId=" + violationTypeId +
				", violationTypeText='" + violationTypeText + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
