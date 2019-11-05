package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The POJO for the Track
 * 
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */

@ApiModel(value = "Track", description = "contains the information about a Track")
public class Track {

	@ApiModelProperty(value = "the track's id")
	private int trackId;

	@ApiModelProperty(value = "the track's title")
	private String title;

	@ApiModelProperty(value = "whether the track is active")
	private boolean isActive;

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + trackId;
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
		Track other = (Track) obj;
		if (trackId != other.trackId)
			return false;
		return true;
	}

	public Track() {
		super();
	}

	public Track(int trackId, String title, boolean isActive) {
		super();
		this.trackId = trackId;
		this.title = title;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Track [trackId=" + trackId + ", title=" + title + ", isActive=" + isActive + "]";
	}

}
