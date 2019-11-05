package com.revature.screenforce.models;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.revature.screenforce.beans.Candidate;

@ApiModel(value = "Full report model", description = "A Full report which holds relevant screening information")
public class FullReportModel {

	@ApiModelProperty(value = "simple report model contained in full report model")
	private SimpleReportModel srm;

	@ApiModelProperty(value = "id of the screener who conducted the screening")
	private int screener_id;

	@ApiModelProperty(value = "candidate Object that has all information of the current Candidate")
	private Candidate candidate;

	@ApiModelProperty(value = "commentary on the candidate's 'about me' description")
	private String aboutMeCommentary;

	@ApiModelProperty(value = "general commentary about the candidate during the screening")
	private String generalCommentary;

	@ApiModelProperty(value = "commentary about the candidate's soft skills during the screening")
	private String softSkillCommentary;

	@ApiModelProperty(value = "verdict as to whether the candidate passed the screening or not")
	private boolean softSkillVerdict;

	@ApiModelProperty(value = "list of categories in which the candidate was tested")
	private List<CategoryModel> categoriesTested;

	@ApiModelProperty(value = "list of violations that were observed during screening")
	private List<ViolationModel> violationsObserved;


	public FullReportModel(SimpleReportModel srm) {
		this.srm = srm;
	}

	public FullReportModel() {
		super();
	}

	public SimpleReportModel getSrm() {
		return srm;
	}

	public void setSrm(SimpleReportModel srm) {
		this.srm = srm;
	}

	public int getScreener_id() {
		return screener_id;
	}

	public void setScreener_id(int screener_id) {
		this.screener_id = screener_id;
	}


	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getAboutMeCommentary() {
		return aboutMeCommentary;
	}

	public void setAboutMeCommentary(String aboutMeCommentary) {
		this.aboutMeCommentary = aboutMeCommentary;
	}

	public String getGeneralCommentary() {
		return generalCommentary;
	}

	public void setGeneralCommentary(String generalCommentary) {
		this.generalCommentary = generalCommentary;
	}

	public String getSoftSkillCommentary() {
		return softSkillCommentary;
	}

	public void setSoftSkillCommentary(String softSkillCommentary) {
		this.softSkillCommentary = softSkillCommentary;
	}

	public boolean isSoftSkillVerdict() {
		return softSkillVerdict;
	}

	public void setSoftSkillVerdict(boolean softSkillVerdict) {
		this.softSkillVerdict = softSkillVerdict;
	}

	public List<CategoryModel> getCategoriesTested() {
		return categoriesTested;
	}

	public void setCategoryModel(List<CategoryModel> categoriesTested) {
		this.categoriesTested = categoriesTested;
	}

	public List<ViolationModel> getViolationsObserved() {
		return violationsObserved;
	}

	public void setViolationsObserved(List<ViolationModel> violationsObserved) {
		this.violationsObserved = violationsObserved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutMeCommentary == null) ? 0 : aboutMeCommentary.hashCode());
		result = prime * result + ((candidate == null) ? 0 : candidate.hashCode());
		result = prime * result + ((categoriesTested == null) ? 0 : categoriesTested.hashCode());
		result = prime * result + ((generalCommentary == null) ? 0 : generalCommentary.hashCode());
		result = prime * result + screener_id;
		result = prime * result + ((softSkillCommentary == null) ? 0 : softSkillCommentary.hashCode());
		result = prime * result + (softSkillVerdict ? 1231 : 1237);
		result = prime * result + ((srm == null) ? 0 : srm.hashCode());
		result = prime * result + ((violationsObserved == null) ? 0 : violationsObserved.hashCode());
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
		FullReportModel other = (FullReportModel) obj;
		if (aboutMeCommentary == null) {
			if (other.aboutMeCommentary != null)
				return false;
		} else if (!aboutMeCommentary.equals(other.aboutMeCommentary))
			return false;
		if (candidate == null) {
			if (other.candidate != null)
				return false;
		} else if (!candidate.equals(other.candidate))
			return false;
		if (categoriesTested == null) {
			if (other.categoriesTested != null)
				return false;
		} else if (!categoriesTested.equals(other.categoriesTested))
			return false;
		if (generalCommentary == null) {
			if (other.generalCommentary != null)
				return false;
		} else if (!generalCommentary.equals(other.generalCommentary))
			return false;
		if (screener_id != other.screener_id)
			return false;
		if (softSkillCommentary == null) {
			if (other.softSkillCommentary != null)
				return false;
		} else if (!softSkillCommentary.equals(other.softSkillCommentary))
			return false;
		if (softSkillVerdict != other.softSkillVerdict)
			return false;
		if (srm == null) {
			if (other.srm != null)
				return false;
		} else if (!srm.equals(other.srm))
			return false;
		if (violationsObserved == null) {
			if (other.violationsObserved != null)
				return false;
		} else if (!violationsObserved.equals(other.violationsObserved))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "FullReportModel [srm=" + srm + ", screener_id=" + screener_id + ", candidate=" + candidate
				+ ", aboutMeCommentary=" + aboutMeCommentary + ", generalCommentary=" + generalCommentary
				+ ", softSkillCommentary=" + softSkillCommentary + ", softSkillVerdict=" + softSkillVerdict
				+ ", categoriesTested=" + categoriesTested + ", violationsObserved=" + violationsObserved + "]";
	}

}
