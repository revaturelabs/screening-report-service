package com.revature.screenforce.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.revature.screenforce.beans.Candidate;



public class FullReportModel {

	private SimpleReportModel srm;
	//The id of the screener
	private int screener_id;
	//A Candidate Object that has all information of the current Candidate 
	private Candidate can;
	//Overall Commentary supplied 
	private String aboutMeCommentary;
	private String generalCommentary;
	private String softSkillCommentary;
	//pass or not
	private boolean softSkillVerdict; 
	//What SkillType is being tested at this time
	//A list of the buckets that was tested for this Candidate
	private List<CategoryModel> BucketTested;
	private List<ViolationModel> violation;

}
