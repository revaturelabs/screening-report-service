package com.revature.screenforce.dtos;

import java.util.Objects;


//5/27 JU Taking whole body of bean from screening application

public class Candidate {

	//variables 

	private int candidateId;


	private String resourceId;


	private String name;


	private String email;


	private String phoneNumber;


	private String skypeId;


	private String profileUrl;


	private String recruiterName;


	private String college;

	private String degree;


	private String major;

	private String techScreenerName;

	//constructors
	public Candidate() {
		super();
	}

	public Candidate(int candidateId, String resourceId, String name, String email, String phoneNumber, String skypeId,
					 String profileUrl, String recruiterName, String college, String degree, String major,
					 String techScreenerName) {
		super();
		this.candidateId = candidateId;
		this.resourceId = resourceId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.skypeId = skypeId;
		this.profileUrl = profileUrl;
		this.recruiterName = recruiterName;
		this.college = college;
		this.degree = degree;
		this.major = major;
		this.techScreenerName = techScreenerName;
	}

	//getters and setters
	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTechScreenerName() {
		return techScreenerName;
	}

	public void setTechScreenerName(String techScreenerName) {
		this.techScreenerName = techScreenerName;
	}

	//equals and hashcode
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Candidate candidate = (Candidate) o;
		return getCandidateId() == candidate.getCandidateId() &&
				Objects.equals(getResourceId(), candidate.getResourceId()) &&
				Objects.equals(getName(), candidate.getName()) &&
				Objects.equals(getEmail(), candidate.getEmail()) &&
				Objects.equals(getPhoneNumber(), candidate.getPhoneNumber()) &&
				Objects.equals(getSkypeId(), candidate.getSkypeId()) &&
				Objects.equals(getProfileUrl(), candidate.getProfileUrl()) &&
				Objects.equals(getRecruiterName(), candidate.getRecruiterName()) &&
				Objects.equals(getCollege(), candidate.getCollege()) &&
				Objects.equals(getDegree(), candidate.getDegree()) &&
				Objects.equals(getMajor(), candidate.getMajor()) &&
				Objects.equals(getTechScreenerName(), candidate.getTechScreenerName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCandidateId(), getResourceId(), getName(), getEmail(), getPhoneNumber(), getSkypeId(), getProfileUrl(), getRecruiterName(), getCollege(), getDegree(), getMajor(), getTechScreenerName());
	}

	//toString
	@Override
	public String toString() {
		return "Candidate{" +
				"candidateId=" + candidateId +
				", resourceId='" + resourceId + '\'' +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", skypeId='" + skypeId + '\'' +
				", profileUrl='" + profileUrl + '\'' +
				", recruiterName='" + recruiterName + '\'' +
				", college='" + college + '\'' +
				", degree='" + degree + '\'' +
				", major='" + major + '\'' +
				", techScreenerName='" + techScreenerName + '\'' +
				'}';
	}
}
