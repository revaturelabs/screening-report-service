package com.revature.screenforce.beans;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TO DO (Unused)
 * we only have screenerId
 * the name and email was stored locally on the h2 db.
 * once db is removed, all sources of name and email are gone.
 */

@ApiModel(value = "Screener", description = "contains the information about the screener")
public class Screener {

	@ApiModelProperty(value = "the screener's id")
	private int screenerId;
	
	@ApiModelProperty(value = "the screener's name")
	private String name;

	@ApiModelProperty(value = "the screener's eail")
	private String email;

	@ApiModelProperty(value = "a list of this screener's screenings")
	private List<Screening> screenings;

	public List<Screening> getScreenings() {
		return screenings;
	}
	
	public boolean hasScreenings() {
		return ((screenings == null) ? false : true);
	}

	public void setScreenings(List<Screening> screenings) {
		this.screenings = screenings;
	}

	public int getScreenerId() {
		return screenerId;
	}

	public void setScreenerId(int screenerId) {
		this.screenerId = screenerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Screener(int screenerId, String name, String email) {
		super();
		this.screenerId = screenerId;
		this.name = name;
		this.email = email;
	}

	public Screener() {
		super();
	}

	@Override
	public String toString() {
		return "Screener [screenerId=" + screenerId + ", " + (name != null ? "name=" + name + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (screenings != null ? "screenings=" + screenings : "") + "]";
	}
}
