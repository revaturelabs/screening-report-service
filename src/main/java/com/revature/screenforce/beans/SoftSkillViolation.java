package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Soft Skills Violation", description = "Any violations that happen during the scourse of a screening")
@Entity 
@Table(name="SOFT_SKILL_VIOLATION")
public class SoftSkillViolation {

	@ApiModelProperty(value = "Id of the violation")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SOFT_SKILL_VIOLATION_ID")
	private int softSkillViolationId;

	@ApiModelProperty(value = "Id of the Screening the violation occurred in")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCREENING_ID")
	private Screening screening;

	@ApiModelProperty(value = "Id of the ViolationType that occurred in the screening")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "VIOLATION_TYPE_ID")
	private ViolationType violationType;
	
	@ApiModelProperty(value = "Set Me!")
	@Column(name="SCREENING_ID", insertable=false, updatable=false)
	private int screeningId;

	@ApiModelProperty(value = "Any comments regarding the violation")
	@Column(name="COMMENT")
	private String comment;

	@ApiModelProperty(value = "Time of the violation")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME")
	private Date time;

	public SoftSkillViolation() {
		super();
	}

	public SoftSkillViolation(int softSkillViolationId, Screening screening, ViolationType violationType, String comment, Date time) {
		super();
		this.softSkillViolationId = softSkillViolationId;
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
	
	public boolean hasViolationType() {
		return ((this.violationType == null) ? false : true);
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
		return getSoftSkillViolationId() == violation.getSoftSkillViolationId() &&
				Objects.equals(getScreening(), violation.getScreening()) &&
				Objects.equals(getViolationType(), violation.getViolationType()) &&
				Objects.equals(getComment(), violation.getComment()) &&
				Objects.equals(getTime(), violation.getTime());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSoftSkillViolationId(), getScreening(), getViolationType(), getComment(), getTime());
	}

	@Override
	public String toString() {
		return "SoftSkillViolation{" +
				"softSkillViolationId=" + softSkillViolationId +
				", screening=" + screening +
				", violationType=" + violationType +
				", comment='" + comment + '\'' +
				", time=" + time +
				'}';
	}

	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}
}
