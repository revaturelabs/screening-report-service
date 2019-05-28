package com.revature.screenforce.dtos;

import java.util.Date;
import java.util.Objects;


//5/27 JU - body from tech-screening application

public class ScheduledScreening {

	//variables

	private int scheduledScreeningId;


	private Candidate candidate;


	private ScheduledStatus scheduledStatus;

	private int skillTypeId;


	private Date scheduledDate;

	//constructors
	public ScheduledScreening() {
		super();
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

	//getters and setters
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

	//equals and hashcode
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ScheduledScreening that = (ScheduledScreening) o;
		return getScheduledScreeningId() == that.getScheduledScreeningId() &&
				getSkillTypeId() == that.getSkillTypeId() &&
				Objects.equals(getCandidate(), that.getCandidate()) &&
				Objects.equals(getScheduledStatus(), that.getScheduledStatus()) &&
				Objects.equals(getScheduledDate(), that.getScheduledDate());
	}
	@Override
	public int hashCode() {
		return Objects.hash(getScheduledScreeningId(), getCandidate(), getScheduledStatus(), getSkillTypeId(), getScheduledDate());
	}

	//toString
	@Override
	public String toString() {
		return "ScheduledScreening{" +
				"scheduledScreeningId=" + scheduledScreeningId +
				", candidate=" + candidate +
				", scheduledStatus='" + scheduledStatus + '\'' +
				", skillTypeId=" + skillTypeId +
				", scheduledDate=" + scheduledDate +
				'}';
	}
}