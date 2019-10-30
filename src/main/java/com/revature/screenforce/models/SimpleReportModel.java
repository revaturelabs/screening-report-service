package com.revature.screenforce.models;

import java.util.Date;

import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.Track;

public class SimpleReportModel {
	private int screeningId;
	private Date screenDate;
	private double compositeScore;
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
	public Date getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(Date screenDate) {
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
