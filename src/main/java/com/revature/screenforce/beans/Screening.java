package com.revature.screenforce.beans;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//import javax.persistence.*;

//import java.time.LocalDate;
import java.util.Date;
//import java.util.List;
//import java.util.Objects;

/**
 *  The POJO for the Screening
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
public class Screening {
	

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

	@Override
	public String toString() {
		return "Screening [screeningId=" + screeningId + ", scheduledScreening=" + scheduledScreening + ", screenerId="
				+ screenerId + ", skillType=" + skillType + ", compositeScore=" + compositeScore
				+ ", aboutMeCommentary=" + aboutMeCommentary + ", generalCommentary=" + generalCommentary
				+ ", softSkillCommentary=" + softSkillCommentary + ", startDateTime=" + startDateTime + ", endDateTime="
				+ endDateTime + ", softSkillsVerdict=" + softSkillsVerdict + ", status=" + status + "]";
	}
	
	
	
	
	
}
