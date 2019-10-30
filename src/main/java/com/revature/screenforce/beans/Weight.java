package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  The POJO for the Weight
 *  the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */

@ApiModel(value = "Weight", description = "contains the information about the weight of a track and category")
public class Weight {

	@ApiModelProperty(value = "the weight's id")
    private long weightId;

	@ApiModelProperty(value = "the weight's value")
    private int weightValue;

	@ApiModelProperty(value = "the current track")
    private Track track;

	@ApiModelProperty(value = "the current category")
    private Category category;

	public long getWeightId() {
		return weightId;
	}

	public void setWeightId(long weightId) {
		this.weightId = weightId;
	}

	public int getWeightValue() {
		return weightValue;
	}

	public void setWeightValue(int weightValue) {
		this.weightValue = weightValue;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Weight(long weightId, int weightValue, Track track, Category category) {
		super();
		this.weightId = weightId;
		this.weightValue = weightValue;
		this.track = track;
		this.category = category;
	}

	public Weight() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (weightId ^ (weightId >>> 32));
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
		Weight other = (Weight) obj;
		if (weightId != other.weightId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weight [weightId=" + weightId + ", weightValue=" + weightValue + ", track=" + track + ", category="
				+ category + "]";
	}

}
