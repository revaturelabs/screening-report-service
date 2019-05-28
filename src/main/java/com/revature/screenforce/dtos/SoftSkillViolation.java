package com.revature.screenforce.dtos;

import java.util.Date;
import java.util.Objects;


//5/27 JU - body from screening application

public class SoftSkillViolation {


	private int softViolationId;


	private Screening screening;


	private ViolationType violationType;


	private String comment;


	private Date time;

	public SoftSkillViolation() {
		super();
	}

	public SoftSkillViolation(int softViolationId, Screening screening, ViolationType violationType, String comment, Date time) {
		super();
		this.softViolationId = softViolationId;
		this.screening = screening;
		this.violationType = violationType;
		this.comment = comment;
		this.time = time;
	}

	public SoftSkillViolation(Screening screening, ViolationType violationType, String comment, Date time) {
		super();
		this.screening = screening;
		this.violationType = violationType;
		this.comment = comment;
		this.time = time;
	}

	public int getSoftViolationId() {
		return softViolationId;
	}

	public void setSoftViolationId(int softViolationId) {
		this.softViolationId = softViolationId;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public ViolationType getViolationType() {
		return violationType;
	}

	public void setViolationType(ViolationType violationType) {
		this.violationType = violationType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SoftSkillViolation violation = (SoftSkillViolation) o;
		return getSoftViolationId() == violation.getSoftViolationId() &&
				Objects.equals(getScreening(), violation.getScreening()) &&
				Objects.equals(getViolationType(), violation.getViolationType()) &&
				Objects.equals(getComment(), violation.getComment()) &&
				Objects.equals(getTime(), violation.getTime());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSoftViolationId(), getScreening(), getViolationType(), getComment(), getTime());
	}

	@Override
	public String toString() {
		return "SoftSkillViolation{" +
				"softViolationId=" + softViolationId +
				", screening=" + screening +
				", violationType=" + violationType +
				", comment='" + comment + '\'' +
				", time=" + time +
				'}';
	}
}