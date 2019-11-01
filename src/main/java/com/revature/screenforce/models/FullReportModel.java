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
	private Candidate can;

	//Overall Commentary supplied
	@ApiModelProperty(value = "commentary on the candidates 'about me' description")
	private String aboutMeCommentary;

	@ApiModelProperty(value = "general commentary about the candidate during the screening")
	private String generalCommentary;

	@ApiModelProperty(value = "commentary about the candidate's soft skills during the screening")
	private String softSkillCommentary;

	@ApiModelProperty(value = "verdict as to whether the candidate passed the screening or not")
	private boolean softSkillVerdict;

	@ApiModelProperty(value = "list of categories in which the candidate was tested")
	private List<CategoryModel> CategoryTested;

	@ApiModelProperty(value = "list of violations that were observed during screening")
	private List<ViolationModel> violation;

	public FullReportModel(SimpleReportModel srm) {
		this.srm = srm;
	}

	public FullReportModel() {
		super();
		// TODO Auto-generated constructor stub
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

	public Candidate getCan() {
		return can;
	}

	public void setCan(Candidate can) {
		this.can = can;
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

	public List<CategoryModel> getCategoryModel() {
		return CategoryTested;
	}

	public void setCategoryModel(List<CategoryModel> categoryTested) {
		CategoryTested = categoryTested;
	}

	public List<ViolationModel> getViolation() {
		return violation;
	}

	public void setViolation(List<ViolationModel> violation) {
		this.violation = violation;
	}

	@Override
	public String toString() {
		return "FullReportModel [srm=" + srm + ", screener_id=" + screener_id + ", can=" + can + ", aboutMeCommentary="
				+ aboutMeCommentary + ", generalCommentary=" + generalCommentary + ", softSkillCommentary="
				+ softSkillCommentary + ", softSkillVerdict=" + softSkillVerdict + ", CategoryTested=" + CategoryTested
				+ ", violation=" + violation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((srm == null) ? 0 : srm.hashCode());
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
		if (srm == null) {
			if (other.srm != null)
				return false;
		} else if (!srm.equals(other.srm))
			return false;
		return true;
	}
	
}
