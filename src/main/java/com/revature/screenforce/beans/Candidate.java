package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  The POJO for the Candidate
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
@ApiModel(value = "Candidate", description = "A Candidate which holds relevant candidate information")
public class Candidate {
	
	@ApiModelProperty(value = "id of the candidate")
	private int candidateId;

	@ApiModelProperty(value = "id of the salesforce which represents the candidate")
	private String resourceId;

	@ApiModelProperty(value = "name of the candidate")
	private String name;

	@ApiModelProperty(value = "email of the candidate")
	private String email;

	@ApiModelProperty(value = "phone number of the candidate")
	private String phoneNumber;

	@ApiModelProperty(value = "skype id of the candidate")
	private String skypeId;

	@ApiModelProperty(value = "the profile url of the candidate")
	private String profileUrl;

	@ApiModelProperty(value = "the name of this candidates recruiter")
	private String recruiterName;

	@ApiModelProperty(value = "the college that the candidate went to")
	private String college;

	@ApiModelProperty(value = "the degree that the candidate received")
	private String degree;

	@ApiModelProperty(value = "the major of the candidate")
	private String major;
	
	@ApiModelProperty(value = "the name of the screener for the candidate")
	private String techScreenerName;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + candidateId;
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
		Candidate other = (Candidate) obj;
		if (candidateId != other.candidateId)
			return false;
		return true;
	}

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", resourceId=" + resourceId + ", name=" + name + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", skypeId=" + skypeId + ", profileUrl=" + profileUrl
				+ ", recruiterName=" + recruiterName + ", college=" + college + ", degree=" + degree + ", major="
				+ major + ", techScreenerName=" + techScreenerName + "]";
	}
	
	
	

}
