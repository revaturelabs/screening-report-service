package com.revature.screenforce.models;

import java.util.List;

public class ReportData {
	/* This class corresponds to the ReportData class in Angular (screening-ui).
	 * The other Report Model Classes that used to be in this folder didn't properly
	 * connect to the frontend,
	 * and they didn't even work in the backend.  Starting fresh!
	 * 
	 * -Adam King
	 * adamdentonking@gmail.com
	 */
	
	public static class Screener {
		private String name;
		private String email;
		public Screener(String name, String email) {
			super();
			this.name = name;
			this.email = email;
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
		
		
	}
	
	public static class BarChartData {
		String name;
		double y;
		public BarChartData(String name, double y) {
			super();
			this.name = name;
			this.y = y;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
		
	}
	
	List<String> hardestQuestions;
	List<BarChartData> avgSkillTypeScore;
	List<BarChartData> avgBucketTypeScore;
	List<BarChartData> violationsByType;
	Integer numApplicantsPassed;
	Integer numApplicantsFailed;
	Screener screener;
	
	public ReportData(List<String> hardestQuestions, List<BarChartData> avgSkillTypeScore,
			List<BarChartData> avgBucketTypeScore, List<BarChartData> violationsByType, Integer numApplicantsPassed,
			Integer numApplicantsFailed, Screener screener) {
		super();
		this.hardestQuestions = hardestQuestions;
		this.avgSkillTypeScore = avgSkillTypeScore;
		this.avgBucketTypeScore = avgBucketTypeScore;
		this.violationsByType = violationsByType;
		this.numApplicantsPassed = numApplicantsPassed;
		this.numApplicantsFailed = numApplicantsFailed;
		this.screener = screener;
		
		
	}

	public List<String> getHardestQuestions() {
		return hardestQuestions;
	}

	public void setHardestQuestions(List<String> hardestQuestions) {
		this.hardestQuestions = hardestQuestions;
	}

	public List<BarChartData> getAvgSkillTypeScore() {
		return avgSkillTypeScore;
	}

	public void setAvgSkillTypeScore(List<BarChartData> avgSkillTypeScore) {
		this.avgSkillTypeScore = avgSkillTypeScore;
	}

	public List<BarChartData> getAvgBucketTypeScore() {
		return avgBucketTypeScore;
	}

	public void setAvgBucketTypeScore(List<BarChartData> avgBucketTypeScore) {
		this.avgBucketTypeScore = avgBucketTypeScore;
	}

	public List<BarChartData> getViolationsByType() {
		return violationsByType;
	}

	public void setViolationsByType(List<BarChartData> violationsByType) {
		this.violationsByType = violationsByType;
	}

	public Integer getNumApplicantsPassed() {
		return numApplicantsPassed;
	}

	public void setNumApplicantsPassed(Integer numApplicantsPassed) {
		this.numApplicantsPassed = numApplicantsPassed;
	}

	public Integer getNumApplicantsFailed() {
		return numApplicantsFailed;
	}

	public void setNumApplicantsFailed(Integer numApplicantsFailed) {
		this.numApplicantsFailed = numApplicantsFailed;
	}

	public Screener getScreener() {
		return screener;
	}

	public void setScreener(Screener screener) {
		this.screener = screener;
	}
	
	
	
	
}
