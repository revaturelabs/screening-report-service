package com.revature.screenforce.beans;

import java.time.LocalDateTime;


/**
 *  The POJO for the Screening
 *  the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
public class Screening {
	

	private int screeningId;

	private ScheduledScreening scheduledScreening;

	private int screenerId;

	private int track;

	private Double compositeScore;

	private String aboutMeCommentary;

	private String generalCommentary;

	private String softSkillCommentary;

	private LocalDateTime startDateTime;

	private LocalDateTime endDateTime;

	private Boolean softSkillsVerdict;

	private String status;

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


	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
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

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + screeningId;
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
		Screening other = (Screening) obj;
		if (screeningId != other.screeningId)
			return false;
		return true;
	}

	public Screening() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Screening(int screeningId, ScheduledScreening scheduledScreening, int screenerId, int track,
			Double compositeScore, String aboutMeCommentary, String generalCommentary, String softSkillCommentary,
			LocalDateTime startDateTime, LocalDateTime endDateTime, Boolean softSkillsVerdict, String status) {
		super();
		this.screeningId = screeningId;
		this.scheduledScreening = scheduledScreening;
		this.screenerId = screenerId;
		this.track = track;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Screening [screeningId=" + screeningId + ", scheduledScreening=" + scheduledScreening + ", screenerId="
				+ screenerId + ", track=" + track + ", compositeScore=" + compositeScore
				+ ", aboutMeCommentary=" + aboutMeCommentary + ", generalCommentary=" + generalCommentary
				+ ", softSkillCommentary=" + softSkillCommentary + ", startDateTime=" + startDateTime + ", endDateTime="
				+ endDateTime + ", softSkillsVerdict=" + softSkillsVerdict + ", status=" + status + "]";
	}
	
	
	
	
	
}
