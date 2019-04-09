package com.revature.screenforce.services;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.beans.Question;
import com.revature.screenforce.beans.QuestionScore;
import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.Screener;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SkillType;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.beans.ViolationType;
import com.revature.screenforce.daos.BucketDAO;
import com.revature.screenforce.daos.QuestionDAO;
import com.revature.screenforce.daos.QuestionScoreRepository;
import com.revature.screenforce.daos.ScreenerRepository;
import com.revature.screenforce.daos.ScreeningRepository;
import com.revature.screenforce.daos.SkillTypeDAO;
import com.revature.screenforce.daos.SoftSkillViolationRepository;
import com.revature.screenforce.daos.ViolationTypeRepository;
import com.revature.screenforce.daos.WeightDAO;
import com.revature.screenforce.models.ReportData;
import com.revature.screenforce.models.ReportData.BarChartData;
import com.revature.screenforce.util.Time;

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
	
	public void printDAOOutputs() {
		System.out.println("Screener Repository findAll");
		System.out.println(screenerRepository.findAll());
		System.out.println("SkillType DAO findAll");
		System.out.println(skillTypeDAO.findAll());
		System.out.println("QuestionScoreRepository findAll");
		System.out.println(questionScoreRepository.findAll());
		System.out.println("Question DAO findAll");
		System.out.println(questionDAO.findAll());
		System.out.println("Soft Skill Violation Repository findAll");
		System.out.println(softSkillViolationRepository.findAll());
		System.out.println("Violation Type Repository findAll");
		System.out.println(violationTypeRepository.findAll());
		System.out.println("Weight DAO findAll");
		System.out.println(weightDAO.findAll());
	}
	
	public String getReport(String[] weeks, Integer screenerId) {
		/*
		 * Big dang report generation.  Generates ReportData that matches ReportData in screening-ui and
		 * works with angular to display charts/info.  Null values for weeks or screenerId will remove
		 * that restriction, so getReport(null, null) returns a report for all screens all time.
		 * 
		 * This used to be two separate functions, neither of which worked.
		 * It's essentially a total rewrite.  It's been split up into some functions but could use more
		 * refactoring.  
		 */
		
		Time time = new Time();
		LocalDate startDate = null;
		LocalDate endDate = null;
		if (weeks != null) {
			startDate = time.getWeekToDate(Integer.parseInt(weeks[1]));
			endDate = time.getWeekToDate(Integer.parseInt(weeks[0]));
		}
		
		// sample data.  Testing one piece at a time!
		List<String> hardestQuestions = Arrays.asList("N/A", "N/A", "N/A", "N/A", "N/A");
		List<ReportData.BarChartData> avgSkillTypeScore = new ArrayList();
		//avgSkillTypeScore.add(new ReportData.BarChartData("skill_test", 10.5));
		
		List<ReportData.BarChartData> avgBucketTypeScore = new ArrayList();
		//avgBucketTypeScore.add(new ReportData.BarChartData("bucket_test", 12.5));
		
		List<ReportData.BarChartData> violationsByType = new ArrayList();
		//violationsByType.add(new ReportData.BarChartData("violation_test", 4));
		
		Integer numApplicantsPassed = 1337;
		Integer numApplicantsFailed = 1337;
		ReportData.Screener screener = new ReportData.Screener("Adam", "adking@mail.com");
		
		// generation of real data beings here, with screenings
		List<Screening> screenings = getScreenings(startDate, endDate, screenerId);
		
		//count the soft skill violations in our screenings using a Map:
		Map<String, Integer> countSoftSkillViolation = new HashMap<>();
		for (Screening s : screenings) {
			List<SoftSkillViolation> ssvs = softSkillViolationRepository.findAllByScreeningId(s.getScreeningId());
			for (SoftSkillViolation ssv : ssvs) {
				String key = ssv.getViolationType().getViolationTypeText();
				if (!countSoftSkillViolation.containsKey(key)) {
					countSoftSkillViolation.put(key, 0);
				}
				countSoftSkillViolation.replace(key, countSoftSkillViolation.get(key) + 1);
			}
		}
		
		// convert count of violations to BarChartData, prep for output
		for (String ssv : countSoftSkillViolation.keySet()) {
			violationsByType.add(new ReportData.BarChartData(
					ssv,
					countSoftSkillViolation.get(ssv)
					));
		}
		
		//get question scores in the range and use them to produce more BarChartData.
		List<QuestionScore> questionScores = getQuestionScores(startDate, endDate, screenerId);
		
		Tallies tallies = tallyScores(questionScores);
		
		// get average of bucket scores as BarChartData
		for (Integer bid : tallies.sumScoresBucket.keySet()) {
			avgBucketTypeScore.add(new ReportData.BarChartData(
					bucketDAO.findById(bid).get().getBucketDescription(),
					tallies.sumScoresBucket.get(bid) / (double) tallies.countBucket.get(bid)
					));
		}

		// get average of Skill Types scores as BarChartData
		for (Integer stid : tallies.sumScoresSkillType.keySet()) {
			avgSkillTypeScore.add(new ReportData.BarChartData(
					skillTypeDAO.findById(stid).get().getTitle(),
					tallies.sumScoresSkillType.get(stid) / (double) tallies.countSkillType.get(stid)
					));
		}
		
		// get average of Question scores in new Map
		Map<Integer, Double> avgScoreQuestion = new HashMap<>();
		for (Integer qid : tallies.sumScoresQuestion.keySet()) {
			avgScoreQuestion.put(qid, tallies.sumScoresQuestion.get(qid) / (double) tallies.countQuestion.get(qid));
		}
		// sort, get top 5
		Set<Integer> keySet = avgScoreQuestion.keySet();
		List<Integer> keyList = new ArrayList<Integer>(keySet);
		
		Collections.sort(keyList, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return Double.compare(avgScoreQuestion.get(i1), avgScoreQuestion.get(i2));
			}
		});
		
		if (keyList.size() > 5) {
			List<String> tempHardestQuestions = new ArrayList<String>();
			for (Integer qid : keyList.subList(0, 5)) {
				tempHardestQuestions.add(questionDAO.findById(qid).get().getQuestionText());
			}
			hardestQuestions = tempHardestQuestions;
		}
		
		//grab screener info for display, if it exists
		if (screenerId != null) {
			Screener tempScreener = screenerRepository.findById(screenerId).get();
			screener.setName(tempScreener.getName());
			screener.setEmail(tempScreener.getEmail());
		} else {
			screener = null;
		}
		
		//get numApplicants stuff
//		for (Screening s : screenings) {
//			System.out.println(s.getScheduledScreening().getScheduledStatus());
//		}
		//turns out numApplicants doesn't exist.  neat!  We can only get pending v completed, not passed v failed.
		numApplicantsPassed = null;
		numApplicantsFailed = null;
		
		//produce final report; serve it as json
		ReportData reportData = new ReportData(
				hardestQuestions,
				avgSkillTypeScore,
				avgBucketTypeScore,
				violationsByType,
				numApplicantsPassed,
				numApplicantsFailed,
				screener);
				
		Gson gson = new Gson();
		String json = gson.toJson(reportData);
		return json;
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
	
	private List<QuestionScore> getQuestionScores() {
		/* 
		 * Returns all question scores
		 * @return List<QuestionScore>
		 */
		return getQuestionScores(null, null, null);
	}
	
	private List<QuestionScore> getQuestionScores(LocalDate startDate, LocalDate endDate, Integer screenerId) {
		/*
		 * Returns all question scores in a date range associated with an individual screener.
		 * Setting screener or date params to null will ignore that constraint.  Note that setting either
		 * date param to null means date is ignored completely.
		 * @return List<QuestionScore>
		 */
		boolean useDateRange = (startDate != null && endDate != null);
		boolean useScreenerId = (screenerId != null);
		
		// convenience changing from LocalDate to Date.  Different pieces in different formats :|
		Date startDateAsDate = null;
		Date endDateAsDate = null;
		if (useDateRange) {
			startDateAsDate = Date.from(startDate.atStartOfDay().toInstant(ZoneOffset.UTC));
			endDateAsDate = Date.from(endDate.atStartOfDay().toInstant(ZoneOffset.UTC));
		}
		
		List<QuestionScore> out = new ArrayList<QuestionScore>();
		
		for (QuestionScore qs : questionScoreRepository.findAll()) {
			boolean addThisQuestion = true;
			if (useDateRange && !(qs.getBeginTime().after(startDateAsDate) && qs.getBeginTime().before(endDateAsDate))) {
				addThisQuestion = false;
			}
			if (useScreenerId && !(qs.getScreening().getScreenerId() == screenerId)) {
				addThisQuestion = false;
			}
			if (addThisQuestion) out.add(qs);
		}
		return out;
	}
	
	private List<Screening> getScreenings(LocalDate startDate, LocalDate endDate, Integer screenerId) {
		/*
		 * Returns a list of screenings associated with a screener and a date range.
		 * null inputs mean that constraint is ignored.
		 * Similar to getQuestionScores().
		 */
		boolean useDateRange = (startDate != null && endDate != null);
		boolean useScreenerId = (screenerId != null);
		
		List<Screening> screenings;
		List<Screening> out = new ArrayList<Screening>();
		
		if (useScreenerId) {
			Screener screener = screenerRepository.findById(screenerId).get();
			screenings = screener.getScreenings();
		} else {
			screenings = screeningRepository.findAll();
		}
		
		if (useDateRange) {
			for (Screening s : screenings) {
				if (s.getEndDateTime().isAfter(startDate) && s.getEndDateTime().isBefore(endDate)) {
					out.add(s);
				}
			}
		} else {
			out = screenings;
		}
		
		return out;
	}
	
}




