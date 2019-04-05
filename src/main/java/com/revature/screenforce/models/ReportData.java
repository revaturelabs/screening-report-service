package com.revature.screenforce.models;

import java.util.List;

public class ReportData {
	/* This class corresponds to the ReportData class in Angular (screening-ui).
	 * The other Report Model Classes in this folder seemingly don't properly
	 * connect to the frontend,
	 * and they're also not built correctly in the backend.  Starting fresh!
	 * 
	 * -Adam King
	 */
	
	public static class Screener {
		String name;
		String email;
		public Screener(String name, String email) {
			super();
			this.name = name;
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
	
	
	
	
}
