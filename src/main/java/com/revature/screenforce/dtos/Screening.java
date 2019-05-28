package com.revature.screenforce.dtos;

import java.util.Date;
import java.util.Objects;



//5/27 JU body from screening application

public class Screening {
	
	//variables


	private int screeningId;

	private ScheduledScreening scheduledScreening;

	private int screenerId;

	private int skillType;

	private Double compositeScore;

	private String aboutMeCommentary;

	private String generalCommentary;

	private String softSkillCommentary;

	private Date startDateTime;

	private Date endDateTime;

	private Boolean softSkillsVerdict;

	private String status;

	//constructor
	public Screening() {
		super();
	}

	public Screening(int screeningId, ScheduledScreening scheduledScreening, int screenerId, int skillType,
			Double compositeScore, String aboutMeCommentary, String generalCommentary, String softSkillCommentary,
			Date startDateTime, Date endDateTime, Boolean softSkillsVerdict, String status) {
		super();
		this.screeningId = screeningId;
		this.scheduledScreening = scheduledScreening;
		this.screenerId = screenerId;
		this.skillType = skillType;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}

	//getters and setters
	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	public ScheduledScreening getScheduledScreening() {
		return scheduledScreening;
	}

	public void setScheduledScreening(ScheduledScreening scheduledScreening) {
		this.scheduledScreening = scheduledScreening;
	}

	public int getScreenerId() {
		return screenerId;
	}

	public void setScreenerId(int screenerId) {
		this.screenerId = screenerId;
	}

	public int getSkillType() {
		return skillType;
	}

	public void setSkillType(int skillType) {
		this.skillType = skillType;
	}

	public Double getCompositeScore() {
		return compositeScore;
	}

	public void setCompositeScore(Double compositeScore) {
		this.compositeScore = compositeScore;
	}

	public String getAboutMeCommentary() {
		return aboutMeCommentary;
	}

	public void setAboutMeCommentary(String aboutMeCommentary) {
		this.aboutMeCommentary = aboutMeCommentary;
	}

	public String getGeneralCommentary() {
		return generalCommentary;
	}

	public void setGeneralCommentary(String generalCommentary) {
		this.generalCommentary = generalCommentary;
	}

	public String getSoftSkillCommentary() {
		return softSkillCommentary;
	}

	public void setSoftSkillCommentary(String softSkillCommentary) {
		this.softSkillCommentary = softSkillCommentary;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Boolean getSoftSkillsVerdict() {
		return softSkillsVerdict;
	}

	public void setSoftSkillsVerdict(Boolean softSkillsVerdict) {
		this.softSkillsVerdict = softSkillsVerdict;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//equals and hashcode
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Screening screening = (Screening) o;
		return getScreeningId() == screening.getScreeningId() &&
				getScreenerId() == screening.getScreenerId() &&
				getSkillType() == screening.getSkillType() &&
				Objects.equals(getScheduledScreening(), screening.getScheduledScreening()) &&
				Objects.equals(getCompositeScore(), screening.getCompositeScore()) &&
				Objects.equals(getAboutMeCommentary(), screening.getAboutMeCommentary()) &&
				Objects.equals(getGeneralCommentary(), screening.getGeneralCommentary()) &&
				Objects.equals(getSoftSkillCommentary(), screening.getSoftSkillCommentary()) &&
				Objects.equals(getStartDateTime(), screening.getStartDateTime()) &&
				Objects.equals(getEndDateTime(), screening.getEndDateTime()) &&
				Objects.equals(getSoftSkillsVerdict(), screening.getSoftSkillsVerdict()) &&
				Objects.equals(getStatus(), screening.getStatus());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getScreeningId(), getScheduledScreening(), getScreenerId(), getSkillType(), getCompositeScore(), getAboutMeCommentary(), getGeneralCommentary(), getSoftSkillCommentary(), getStartDateTime(), getEndDateTime(), getSoftSkillsVerdict(), getStatus());
	}

	//toString
	@Override
	public String toString() {
		return "Screening{" +
				"screeningId=" + screeningId +
				", scheduledScreening=" + scheduledScreening +
				", screenerId=" + screenerId +
				", skillType=" + skillType +
				", compositeScore=" + compositeScore +
				", aboutMeCommentary='" + aboutMeCommentary + '\'' +
				", generalCommentary='" + generalCommentary + '\'' +
				", softSkillCommentary='" + softSkillCommentary + '\'' +
				", startDateTime=" + startDateTime +
				", endDateTime=" + endDateTime +
				", softSkillsVerdict=" + softSkillsVerdict +
				", status=" + status +
				'}';
	}
}