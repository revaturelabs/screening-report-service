package com.revature.screenforce.models;

<<<<<<< HEAD
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

=======
import java.time.LocalDateTime;
>>>>>>> 6e9ab08ac86480033bffc98ba42e602cc93e2205
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.Track;

@ApiModel(value = "Simple model", description = "A simplied version of the screening full report")
public class SimpleReportModel {

	@ApiModelProperty(value = "id of the simple report")
	private int screeningId;


	@ApiModelProperty(value = "date of the screening")
	private LocalDateTime screenDate;

	@ApiModelProperty(value = "cumulative score of the screening")
	private double compositeScore;

	@ApiModelProperty(value = "track of the screening report")
	private Track track;

	public SimpleReportModel() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public SimpleReportModel(Screening s) {
		this.screeningId= s.getScreeningId();
		this.screenDate = s.getEndDateTime();
		this.compositeScore = s.getCompositeScore();
	}
	public SimpleReportModel(Screening s, Track t) {
		this.screeningId= s.getScreeningId();
		this.screenDate = s.getEndDateTime();
		this.compositeScore = s.getCompositeScore();
		this.track = t;
	}
	@Override
	public String toString() {
		return "SimpleReportModel [screeningId=" + screeningId + ", screenDate=" + screenDate + ", compositeScore="
				+ compositeScore + ", track=" + track + "]";
	}
	public int getScreeningId() {
		return screeningId;
	}
	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}
	public LocalDateTime getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(LocalDateTime screenDate) {
		this.screenDate = screenDate;
	}
	public double getCompositeScore() {
		return compositeScore;
	}
	public void setCompositeScore(double compositeScore) {
		this.compositeScore = compositeScore;
	}
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
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
		SimpleReportModel other = (SimpleReportModel) obj;
		if (screeningId != other.screeningId)
			return false;
		return true;
	}
	
}
