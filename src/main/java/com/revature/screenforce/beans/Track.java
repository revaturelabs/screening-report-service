package com.revature.screenforce.beans;


/**
 *  The POJO for the SkillType
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */

//Hi Future Rex

public class Track  {


	private int trackId;

	private String title;

    private boolean isActive;

	public int getTrackId() {
		return trackId;
	}

	public void setSkillTypeId(int trackId) {
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
		// TODO Auto-generated constructor stub
	}

	public Track(int trackId, String title, boolean isActive) {
		super();
		this.trackId = trackId;
		this.title = title;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "SkillType [trackId=" + trackId + ", title=" + title + ", isActive=" + isActive + "]";
	}
  
    
    
}
