package com.revature.screenforce.beans;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The POJO for the ScheduledScreening the declaration is from feign client,
 * used in the feign folder
 * 
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
@ApiModel(value = "ScheduledScreening", description = "contains the screening date")
public class ScheduledScreening {

	@ApiModelProperty(value = "the scheduled screening id")
	private int scheduledScreeningId;

	@ApiModelProperty(value = "the current candidate")
	private Candidate candidate;

	@ApiModelProperty(value = "the scheduled status")
	private ScheduledStatus scheduledStatus;

	@ApiModelProperty(value = "the track id")
	private int TrackId;

	@ApiModelProperty(value = "the date for the current screening")
	private LocalDateTime scheduledDate;

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

	public int getTrackId() {
		return TrackId;
	}

	public void setTrackId(int trackId) {
		TrackId = trackId;
	}

	public LocalDateTime getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDateTime scheduledDate) {
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
			int TrackId, LocalDateTime scheduledDate) {
		super();
		this.scheduledScreeningId = scheduledScreeningId;
		this.candidate = candidate;
		this.scheduledStatus = scheduledStatus;
		this.TrackId = TrackId;
		this.scheduledDate = scheduledDate;
	}

	@Override
	public String toString() {
		return "ScheduledScreening [scheduledScreeningId=" + scheduledScreeningId + ", candidate=" + candidate
				+ ", scheduledStatus=" + scheduledStatus + ", TrackId=" + TrackId + ", scheduledDate=" + scheduledDate
				+ "]";
	}

}
