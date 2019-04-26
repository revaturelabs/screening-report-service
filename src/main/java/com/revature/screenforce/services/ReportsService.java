package com.revature.screenforce.services;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.revature.screenforce.beans.QuestionScore;
import com.revature.screenforce.beans.Screener;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.daos.BucketDAO;
import com.revature.screenforce.daos.QuestionDAO;
//import com.revature.screenforce.daos.QuestionDAO;
import com.revature.screenforce.daos.QuestionScoreRepository;
import com.revature.screenforce.daos.ScreenerRepository;
import com.revature.screenforce.daos.ScreeningRepository;
import com.revature.screenforce.daos.SkillTypeDAO;
import com.revature.screenforce.daos.SoftSkillViolationRepository;
import com.revature.screenforce.daos.ViolationTypeRepository;
import com.revature.screenforce.daos.WeightDAO;
import com.revature.screenforce.models.ReportData;
import com.revature.screenforce.models.ReportData.BarChartData;

@Service
public class ReportsService {
	@Autowired ScreenerRepository screenerRepository;
	@Autowired SkillTypeDAO skillTypeDAO;
	@Autowired QuestionScoreRepository questionScoreRepository;
	@Autowired QuestionDAO questionDAO;
	@Autowired SoftSkillViolationRepository softSkillViolationRepository;
	@Autowired ViolationTypeRepository violationTypeRepository;
	@Autowired WeightDAO weightDAO;
	@Autowired BucketDAO bucketDAO;
	@Autowired ScreeningRepository screeningRepository;
	
	public List<String> getAllEmails(String email){
		List<Screener> screenerList = screenerRepository.findAllByEmailContainingIgnoreCase(email);
		List<String> emailList = new ArrayList<>();
		for(Screener screener : screenerList) {
				emailList.add(screener.getEmail());
		}
		return emailList;
	}
	
	public List<Screening> getAllScreenings() {
		return this.screeningRepository.findAll();
	}
	
	public List<SoftSkillViolation> getAllSoftSkillViolations() {
		return this.softSkillViolationRepository.findAll();
	}
	
	public List<QuestionScore> getAllQuestionScores() {
		return this.questionScoreRepository.findAll();
	}
 	
	public Integer getIdFromEmail(String email) {
		Screener screener = screenerRepository.getByEmail(email);
		return screener.getScreenerId();
	}
	
	public String getReport(LocalDate startDate, LocalDate endDate, Integer screenerId) {
		return null;
	}
	public String getReport(LocalDate startDate, LocalDate endDate) {
		return null;
	}
	public String getReport( Integer screenerId) {
		return null;
	}
	public String getReport() {
		return null;
	}

	
	private class Tallies {
		// contains an entry for each question, skilltype, and bucket.  Keys are Ids.  Sum of scores for each for value.
		Map<Integer, Double> sumScoresQuestion = new HashMap<>();
		Map<Integer, Double> sumScoresSkillType = new HashMap<>();
		Map<Integer, Double> sumScoresBucket = new HashMap<>();
		// contains an entry for each question, skilltype, and bucket.  Keys are Ids.  Count of questions for each for value.
		Map<Integer, Integer> countQuestion = new HashMap<>();
		Map<Integer, Integer> countSkillType = new HashMap<>();
		Map<Integer, Integer> countBucket = new HashMap<>();
		
	}
	
	private Tallies tallyScores(List<QuestionScore> questionScores) {
		/*
		 * Returns a Tallies object, that sums question scores and counts for question, bucket, and skilltype
		 */
		
		Tallies tallies = new Tallies();
		
		for (QuestionScore qs: questionScores) {
			Integer qid = qs.getQuestionId();
			Integer stid = qs.getScreening().getSkillTypeId();
			Integer bid = qs.getBucketId();
			Double score = qs.getScore();
			
			// initialize entries if they don't exist
			if (!tallies.sumScoresQuestion.containsKey(qid)) tallies.sumScoresQuestion.put(qid, 0.0);
			if (!tallies.sumScoresSkillType.containsKey(stid)) tallies.sumScoresSkillType.put(stid, 0.0);
			if (!tallies.sumScoresBucket.containsKey(bid)) tallies.sumScoresBucket.put(bid, 0.0);
			if (!tallies.countQuestion.containsKey(qid)) tallies.countQuestion.put(qid, 0);
			if (!tallies.countSkillType.containsKey(stid)) tallies.countSkillType.put(stid, 0);
			if (!tallies.countBucket.containsKey(bid)) tallies.countBucket.put(bid, 0);
			
			// add scores and counts
			tallies.sumScoresQuestion.replace(qid, tallies.sumScoresQuestion.get(qid) + score);
			tallies.sumScoresSkillType.replace(stid, tallies.sumScoresSkillType.get(stid) + score);
			tallies.sumScoresBucket.replace(bid, tallies.sumScoresBucket.get(bid) + score);
			tallies.countQuestion.replace(qid,  tallies.countQuestion.get(qid) + 1);
			tallies.countSkillType.replace(stid,  tallies.countSkillType.get(stid) + 1);
			tallies.countBucket.replace(bid,  tallies.countBucket.get(bid) + 1);
			}
		
		return tallies;
	}
	
	
	
}




