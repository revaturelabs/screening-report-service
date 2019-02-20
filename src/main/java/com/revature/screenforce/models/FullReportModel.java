package com.revature.screenforce.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FullReportModel {
	List<ScreenerInfoModel> screeners = new ArrayList<>();
	Map<String, Double> scoresByQuestion = new TreeMap<String, Double>();
	Map<String, Double> scoresBySkillType = new HashMap<String, Double>();
	Map<String, Double> scoresByDescription = new HashMap<String, Double>();
	Map<String, Integer> numViolationsByType = new HashMap<String, Integer>();
	int numScheduledScreenings;
	
	public FullReportModel(List<ScreenerInfoModel> screeners, 
		Map<String, Double> scoresBySkillType,
		Map<String, Double> scoresByDescription,
		Map<String, Double> scoresByQuestion,
		Map<String, Integer> numViolationsByType,
		int numScheduledScreenings) {
		
		this.screeners = screeners;
		this.scoresBySkillType = scoresBySkillType;
		this.scoresByDescription = scoresByDescription;
		this.scoresByQuestion = scoresByQuestion;
		this.numViolationsByType = numViolationsByType;
		this.numScheduledScreenings = numScheduledScreenings;
	}
}
