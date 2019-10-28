package com.revature.screenforce.beans;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//import javax.persistence.*;
import java.util.Date;
//import java.util.Objects;

/**
 *  The POJO for the ScheduledScreening
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
public class ScheduledScreening {

	private int scheduledScreeningId;
	private Candidate candidate;
	private ScheduledStatus scheduledStatus;
	private int skillTypeId;
	private Date scheduledDate;
	public int getScheduledScreeningId() {
		return scheduledScreeningId;
	}
	public void setScheduledScreeningId(int scheduledScreeningId) {
		this.scheduledScreeningId = scheduledScreeningId;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public ScheduledStatus getScheduledStatus() {
		return scheduledStatus;
	}
	public void setScheduledStatus(ScheduledStatus scheduledStatus) {
		this.scheduledStatus = scheduledStatus;
	}
	public int getSkillTypeId() {
		return skillTypeId;
	}
	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}
	public Date getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + scheduledScreeningId;
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
		ScheduledScreening other = (ScheduledScreening) obj;
		if (scheduledScreeningId != other.scheduledScreeningId)
			return false;
		return true;
	}
	public ScheduledScreening() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduledScreening(int scheduledScreeningId, Candidate candidate, ScheduledStatus scheduledStatus,
			int skillTypeId, Date scheduledDate) {
		super();
		this.scheduledScreeningId = scheduledScreeningId;
		this.candidate = candidate;
		this.scheduledStatus = scheduledStatus;
		this.skillTypeId = skillTypeId;
		this.scheduledDate = scheduledDate;
	}
	@Override
	public String toString() {
		return "ScheduledScreening [scheduledScreeningId=" + scheduledScreeningId + ", candidate=" + candidate
				+ ", scheduledStatus=" + scheduledStatus + ", skillTypeId=" + skillTypeId + ", scheduledDate="
				+ scheduledDate + "]";
	}
	
	
	
}
