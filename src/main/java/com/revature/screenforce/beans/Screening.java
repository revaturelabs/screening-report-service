package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Screening", description = "An object to record the result of screening a candidate")
@Entity
@Table(name = "SCREENING")
public class Screening {
	@ApiModelProperty(value = "Id of the screening")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SCREENING_ID")
	private int screeningId;

	@ApiModelProperty(value = "The Scheduled Screening connected to the screening")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCHEDULED_SCREENING_ID")
	private ScheduledScreening scheduledScreening;

	@ApiModelProperty(value = "Id of the person screening the candidate")
	@Column(name = "SCREENER_ID")
	private int screenerId;

	@ApiModelProperty(value = "Id referencing a training track in the screening-admin-service")
	@Column(name = "SKILL_TYPE_ID")
	private int skillTypeId;

	@ApiModelProperty(value = "The total score the candidate recieved")
	@Column(name = "COMPOSITE_SCORE")
	private Double compositeScore;

	@ApiModelProperty(value = "Comments regarding candidate's introduction")
	@Column(name = "ABOUT_COMMENT")
	private String aboutMeCommentary;

	@ApiModelProperty(value = "General commentary regarding the candidate's screening")
	@Column(name = "GENERAL_COMMENT")
	private String generalCommentary;

	@ApiModelProperty(value = "Commentary regarding candidate's soft skills")
	@Column(name = "SOFT_SKILL_COMMENT")
	private String softSkillCommentary;

	@ApiModelProperty(value = "Starting date and time of the screening")
	@Column(name = "START_DATE")
	private LocalDate startDateTime;

	@ApiModelProperty(value = "Ending date and time of the screening")
	@Column(name = "END_DATE")
	private LocalDate endDateTime;

	@ApiModelProperty(value = "Final verdict on the candidate's soft skills")
	@Column(name = "SOFT_SKILL_VERDICT")
	private Boolean softSkillsVerdict;

	@ApiModelProperty(value = "Enum denoting the current status of the screening")
	@Column(name = "STATUS")
	private String status;
	
	@ApiModelProperty(value = "The Screening connected to the screening")
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCREENING_ID")
	private List<Bucket> buckets;

	public List<Bucket> getBuckets() {
		return buckets;
	}

	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}

	public Screening() {
		super();
	}
	public Screening(ScheduledScreening scheduledScreening, int screenerId, 
			int skillTypeId, Double compositeScore, String aboutMeCommentary, 
			String generalCommentary, String softSkillCommentary, LocalDate startDateTime, 
			LocalDate endDateTime, Boolean softSkillsVerdict, String status) {
		this.scheduledScreening = scheduledScreening;
		this.screenerId = screenerId;
		this.skillTypeId = skillTypeId;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}

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

	public int getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
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

	public LocalDate getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDate startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDate getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDate endDateTime) {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Screening screening = (Screening) o;
		return getScreeningId() == screening.getScreeningId() &&
				getScreenerId() == screening.getScreenerId() &&
				getSkillTypeId() == screening.getSkillTypeId() &&
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
		return Objects.hash(getScreeningId(), getScheduledScreening(), getScreenerId(), getSkillTypeId(), getCompositeScore(), getAboutMeCommentary(), getGeneralCommentary(), getSoftSkillCommentary(), getStartDateTime(), getEndDateTime(), getSoftSkillsVerdict(), getStatus());
	}

	@Override
	public String toString() {
		return "Screening{" +
				"screeningId=" + screeningId +
				", scheduledScreening=" + scheduledScreening +
				", screenerId=" + screenerId +
				", skillType=" + skillTypeId +
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
