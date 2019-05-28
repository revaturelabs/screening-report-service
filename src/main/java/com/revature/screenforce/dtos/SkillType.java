package com.revature.screenforce.dtos;

import java.io.Serializable;
import java.util.Objects;


//5/27 JU - body from admin application

public class SkillType implements Serializable {

	private static final long serialVersionUID = -6863562903787298483L;

	private int skillTypeId;

	private String title;
	
    private boolean isActive;
	
	public SkillType() {
		super();
	}

	public SkillType(String title, boolean isActive) {
		this.title = title;
		this.isActive = isActive;
	}

	/**
	 * getters & setters
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SkillType skillType = (SkillType) o;
		return getSkillTypeId() == skillType.getSkillTypeId() &&
				isActive() == skillType.isActive() &&
				Objects.equals(getTitle(), skillType.getTitle());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSkillTypeId(), getTitle(), isActive());
	}

	@Override
	public String toString() {
		return "SkillType{" +
				"skillTypeId=" + skillTypeId +
				", title='" + title + '\'' +
				", isActive=" + isActive +
				'}';
	}
}