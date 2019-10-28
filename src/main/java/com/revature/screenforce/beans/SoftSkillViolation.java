package com.revature.screenforce.beans;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
import java.util.Date;
//import java.util.Objects;

/**
 *  The POJO for the SoftSkillViolation
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
//Hi Future Rex
public class SoftSkillViolation {

	private int softViolationId;

	private Screening screening;

	private ViolationType violationType;

	private String comment;

	private Date time;


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


	public SoftSkillViolation() {
		super();
	}


	public SoftSkillViolation(int softViolationId, Screening screening, ViolationType violationType, String comment,
			Date time) {
		super();
		this.softViolationId = softViolationId;
		this.screening = screening;
		this.violationType = violationType;
		this.comment = comment;
		this.time = time;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + softViolationId;
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
		if (softViolationId != other.softViolationId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SoftSkillViolation [softViolationId=" + softViolationId + ", screening=" + screening
				+ ", violationType=" + violationType + ", comment=" + comment + ", time=" + time + "]";
	}
	
	
}
