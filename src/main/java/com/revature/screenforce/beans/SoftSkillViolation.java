package com.revature.screenforce.beans;


import java.util.Date;


/**
 *  The POJO for the SoftSkillViolation
 *  the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
//Hi Future Rex
public class SoftSkillViolation {

	private int softSkillViolationId;

	private Screening screening;

	private ViolationType violationType;

	private String comment;

	private Date time;


	public int getSoftSkillViolationId() {
		return softSkillViolationId;
	}


	public void setSoftSkillViolationId(int softSkillViolationId) {
		this.softSkillViolationId = softSkillViolationId;
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


	public SoftSkillViolation() {
		super();
	}


	public SoftSkillViolation(int softSkillViolationId, Screening screening, ViolationType violationType, String comment,
			Date time) {
		super();
		this.softSkillViolationId = softSkillViolationId;
		this.screening = screening;
		this.violationType = violationType;
		this.comment = comment;
		this.time = time;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + softSkillViolationId;
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
		SoftSkillViolation other = (SoftSkillViolation) obj;
		if (softSkillViolationId != other.softSkillViolationId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SoftSkillViolation [softSkillViolationId=" + softSkillViolationId + ", screening=" + screening
				+ ", violationType=" + violationType + ", comment=" + comment + ", time=" + time + "]";
	}
	
	
}
