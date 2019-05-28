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
		/*
		 * Overloaded getReport() method to get a specific week for a specific screener,
		 * mapped by /getReport. Returns a reportData via a String of json.
		 * @param startDate Screening period begin date.
		 * @param endDate Screening period end date.
		 * @param screenerId Id of screener that performed screening.
		 * @return json value of a reportData object
		 */
		Integer numApplicantsPassed;
		Integer numApplicantsFailed;
		
		List<Screening> screenings = getScreenings(startDate, endDate, screenerId);
		List<ReportData.BarChartData> violationsByType = violationsByType(screenings);
		List<QuestionScore> questionScores = getQuestionScores(startDate, endDate, screenerId);
		List<ReportData.BarChartData> avgBucketTypeScore = avgBucketTypeScore(questionScores);
		List<ReportData.BarChartData> avgSkillTypeScore = avgSkillTypeScore(questionScores);
		List<String> hardestQuestions = hardestQuestions(questionScores);
		
		Screener tempScreener = screenerRepository.findById(screenerId).get();
		ReportData.Screener screener = new ReportData.Screener(tempScreener.getName(), tempScreener.getEmail());
			
		numApplicantsPassed = numApplicantsPassed(screenings);
		numApplicantsFailed = numApplicantsFailed(screenings);
		
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
	
	public String getReport(LocalDate startDate, LocalDate endDate) {
		/*
		 * Overloaded getReport() method to get a report of screenings 
		 * in a specific week, mapped by /getWeeksReport. Returns a 
		 * reportData via a String of json.
		 * @param startDate Screening period begin date.
		 * @param endDate Screening period end date.
		 * @return json value of a reportData object
		 */
		Integer numApplicantsPassed;
		Integer numApplicantsFailed;
		ReportData.Screener screener = null;
		
		List<Screening> screenings = getScreenings(startDate, endDate);
		List<ReportData.BarChartData> violationsByType = violationsByType(screenings);
		List<QuestionScore> questionScores = getQuestionScores(startDate, endDate);
		List<ReportData.BarChartData> avgBucketTypeScore = avgBucketTypeScore(questionScores);
		List<ReportData.BarChartData> avgSkillTypeScore = avgSkillTypeScore(questionScores);
		List<String> hardestQuestions = hardestQuestions(questionScores);
			
		numApplicantsPassed = numApplicantsPassed(screenings);
		numApplicantsFailed = numApplicantsFailed(screenings);
		
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
	
	public String getReport(Integer screenerId) {
		/*
		 * Overloaded getReport() method to get a report of screenings performed 
		 * by a specific screener, mapped by /getScreenerReport. Returns a 
		 * reportData via a String of json.
		 * @param screenerId Id of screener that performed screening.
		 * @return json value of a reportData object
		 */
		Integer numApplicantsPassed;
		Integer numApplicantsFailed;
		
		List<Screening> screenings = getScreenings(screenerId);
		List<ReportData.BarChartData> violationsByType = violationsByType(screenings);
		List<QuestionScore> questionScores = getQuestionScores(screenerId);
		List<ReportData.BarChartData> avgBucketTypeScore = avgBucketTypeScore(questionScores);
		List<ReportData.BarChartData> avgSkillTypeScore = avgSkillTypeScore(questionScores);
		List<String> hardestQuestions = hardestQuestions(questionScores);
		
		Screener tempScreener = screenerRepository.findById(screenerId).get();
		ReportData.Screener screener = new ReportData.Screener(tempScreener.getName(), tempScreener.getEmail());
			
		numApplicantsPassed = numApplicantsPassed(screenings);
		numApplicantsFailed = numApplicantsFailed(screenings);
		
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
	
	public String getReport() {
		/*
		 * Overloaded getReport() method to get a report of all of the screenings,
		 * mapped by /getTotalReport. Returns a reportData via a String of json.
		 * @return json value of a reportData object
		 */
		Integer numApplicantsPassed = 0;
		Integer numApplicantsFailed = 0;
		
		List<Screening> screenings = getScreenings();
		List<ReportData.BarChartData> violationsByType = violationsByType(screenings);
		List<QuestionScore> questionScores = getQuestionScores();
		List<ReportData.BarChartData> avgBucketTypeScore = avgBucketTypeScore(questionScores);
		List<ReportData.BarChartData> avgSkillTypeScore = avgSkillTypeScore(questionScores);
		List<String> hardestQuestions = hardestQuestions(questionScores);
		
		ReportData.Screener screener = null;
			
		numApplicantsPassed = numApplicantsPassed(screenings);
		numApplicantsFailed = numApplicantsFailed(screenings);
		
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

	
	private List<String> hardestQuestions(List<QuestionScore> questionScores){
		/*
		 * Returns a List containing the five hardest questions asked
		 * by screeners. Creates a Map, sorts it by difficulty, then 
		 * pulls out the first five questions and returns it.
		 * @param questionScores Collection of scores for questions, skill types,
		 * 				  		and buckets.
		 * @return List of the five hardest questions asked.
		 */
		Map<Integer, Double> sumScoresQuestion = new HashMap<>();
        Map<Integer, Integer> countQuestion = new HashMap<>();
        
        for (QuestionScore qs: questionScores) {
            Integer QuestionId = qs.getQuestionId();
            Double score = qs.getScore();
            
            if (!sumScoresQuestion.containsKey(QuestionId)) sumScoresQuestion.put(QuestionId, 0.0);
            if (!countQuestion.containsKey(QuestionId)) countQuestion.put(QuestionId, 0);
            
            sumScoresQuestion.replace(QuestionId, sumScoresQuestion.get(QuestionId) + score);
            countQuestion.replace(QuestionId,  countQuestion.get(QuestionId) + 1);
        }
        
		Map<Integer, Double> avgScoreQuestion = new HashMap<>();
		for (Integer questionId : sumScoresQuestion.keySet()) {
			avgScoreQuestion.put(questionId, sumScoresQuestion.get(questionId) / (double) countQuestion.get(questionId));
		}
		List<Integer> keyList = new ArrayList<Integer>(avgScoreQuestion.keySet());
		
		Collections.sort(keyList, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return Double.compare(avgScoreQuestion.get(i1), avgScoreQuestion.get(i2));
			}
		});
		
		List<String> hardestQuestions = Arrays.asList("N/A", "N/A", "N/A", "N/A", "N/A");
		if (keyList.size() > 5) {
			List<String> tempHardestQuestions = new ArrayList<String>();
			for (Integer questionId : keyList.subList(0, 5)) {
				tempHardestQuestions.add(questionDAO.findById(questionId).get().getQuestionText());
			}
			hardestQuestions = tempHardestQuestions;
		}
		return hardestQuestions;	
	}
	
	
	private List<ReportData.BarChartData> avgSkillTypeScore(List<QuestionScore> questionScores){
		/*
		 * Returns a List of bar chart data to display in the front end.
		 * @param questionScores Collection of scores for questions, skill types,
		 * 				  		and buckets.
		 * @return List of average scores per skill type formatted for a bar chart.
		 */
		Map<Integer, Double> sumScoresSkillType = new HashMap<>();
        Map<Integer, Integer> countSkillType = new HashMap<>();
        
        for (QuestionScore qs: questionScores) {
            Integer skillTypeId = qs.getScreening().getSkillTypeId();
            Double score = qs.getScore();
            
            if (!sumScoresSkillType.containsKey(skillTypeId)) sumScoresSkillType.put(skillTypeId, 0.0);
            if (!countSkillType.containsKey(skillTypeId)) countSkillType.put(skillTypeId, 0);
            
            sumScoresSkillType.replace(skillTypeId, sumScoresSkillType.get(skillTypeId) + score);
            countSkillType.replace(skillTypeId,  countSkillType.get(skillTypeId) + 1);
        }
		
		List<ReportData.BarChartData> avgSkillTypeScore = new ArrayList<BarChartData>();
		for (Integer skillTypeId : sumScoresSkillType.keySet()) {
			avgSkillTypeScore.add(new ReportData.BarChartData(
					skillTypeDAO.findById(skillTypeId).get().getTitle(),
					sumScoresSkillType.get(skillTypeId) / (double) countSkillType.get(skillTypeId)
					));
		}
		return avgSkillTypeScore;	
	}
	
	private List<ReportData.BarChartData> avgBucketTypeScore(List<QuestionScore> questionScores){
		/*
		 * Returns a List of bar chart data to display in the front end.
		 * @param questionScores Collection of scores for questions, skill types,
		 * 				  		and buckets.
		 * @return List of average scores per bucket type formatted for a bar chart.
		 */
		Map<Integer, Double> sumScoresBucket = new HashMap<>();
        Map<Integer, Integer> countBucket = new HashMap<>();
        
        for (QuestionScore qs: questionScores) {
            Integer bucketId = qs.getBucketId();
            Double score = qs.getScore();
            
            if (!sumScoresBucket.containsKey(bucketId)) sumScoresBucket.put(bucketId, 0.0);
            if (!countBucket.containsKey(bucketId)) countBucket.put(bucketId, 0);
            
            sumScoresBucket.replace(bucketId, sumScoresBucket.get(bucketId) + score);
            countBucket.replace(bucketId,  countBucket.get(bucketId) + 1);
        }
		
        List<ReportData.BarChartData> avgBucketTypeScore = new ArrayList<BarChartData>();
        for (Integer bid : sumScoresBucket.keySet()) {
            avgBucketTypeScore.add(new ReportData.BarChartData(
                    bucketDAO.findById(bid).get().getBucketDescription(),
                    sumScoresBucket.get(bid) / (double) countBucket.get(bid)
                    ));
        }
        return avgBucketTypeScore;
	}
	
	private List<ReportData.BarChartData> violationsByType(List<Screening> screenings){
		/*
		 * Gets all violations from each screening and returns a List of 
		 * bar chart data to display in the front end.
		 * @param screenings List of screenings from specified time period.
		 * @return List of violations committed, formatted for a bar chart.
		 */
		Map<String, Integer> countSoftSkillViolation = new HashMap<>();
		for (Screening s : screenings) {
			List<SoftSkillViolation> softSkillsViolations = softSkillViolationRepository.findAllByScreeningId(s.getScreeningId());
			for (SoftSkillViolation softSkillsViolation : softSkillsViolations) {
				String key = softSkillsViolation.getViolationType().getViolationTypeText();
				if (!countSoftSkillViolation.containsKey(key)) {
					countSoftSkillViolation.put(key, 0);
				}
				countSoftSkillViolation.replace(key, countSoftSkillViolation.get(key) + 1);
			}
		}
		
		List<ReportData.BarChartData> violationsByType = new ArrayList<BarChartData>();
		for (String ssv : countSoftSkillViolation.keySet()) {
			violationsByType.add(new ReportData.BarChartData(
					ssv,
					countSoftSkillViolation.get(ssv)
					));
		}
		
		return violationsByType;
	}
	
	private Integer numApplicantsPassed(List<Screening> screenings) {
		/*
		 * Returns an integer amount of applicants with a passing composite score above 70 .
		 * @param  screenings List of screenings according to the given date range.
		 * @return numApplicantsPassed from screenings
		 */
		Integer numApplicantsPassed = 0;
		for (Screening s : screenings) {
            double compScore = s.getCompositeScore();
            if (compScore >= 70) {
                numApplicantsPassed +=1;
            }
        }
		return numApplicantsPassed;
	}
	
	private Integer numApplicantsFailed(List<Screening> screenings) {
		/*
		 * Returns an integer amount of applicants with a failing composite score below 70 .
		 * @param  screenings List of screenings according to the given date range.
		 * @return numApplicantsFailed from screenings
		 */
		Integer numApplicantsFailed = 0;
		for (Screening s : screenings) {
            double compScore = s.getCompositeScore();
            if (compScore < 70) {
                numApplicantsFailed +=1;
            }
        }
		return numApplicantsFailed;
	}
	
	private List<QuestionScore> getQuestionScores(LocalDate startDate, LocalDate endDate, Integer screenerId) {
		/*
		 * Overloaded for /getReport. Returns all question scores in a date range associated with an individual screener.
		 * @return List<QuestionScore>
		 */
		Date startDateAsDate = Date.from(startDate.atStartOfDay().toInstant(ZoneOffset.UTC));
		Date endDateAsDate = Date.from(endDate.atStartOfDay().toInstant(ZoneOffset.UTC));
		
		List<QuestionScore> out = new ArrayList<QuestionScore>();
		
		for (QuestionScore qs : questionScoreRepository.findAll()) {
			if (qs.getBeginTime().after(startDateAsDate) && qs.getBeginTime().before(endDateAsDate)) {
				if (qs.getScreening().getScreenerId() == screenerId) {
					out.add(qs);
				}
			}
		}
		return out;
	}
	
	private List<Screening> getScreenings(LocalDate startDate, LocalDate endDate, Integer screenerId) {
		/*
		 * Overloaded for /getReport. Returns all screenings in a date range associated with an individual screener.
		 * @return List<QuestionScore>
		 */
		List<Screening> screenings;
		List<Screening> out = new ArrayList<Screening>();
		
		Screener screener = screenerRepository.findById(screenerId).get();
		screenings = screener.getScreenings();
		for (Screening s : screenings) {
			if (s.getEndDateTime().isAfter(startDate) && s.getEndDateTime().isBefore(endDate)) {
				out.add(s);
			}
		}
		return out;
	}
	
	private List<QuestionScore> getQuestionScores(LocalDate startDate, LocalDate endDate) {
		/*
		 * Overloaded for /getWeeksReport. Returns all question scores in a date range.
		 * @return List<QuestionScore>
		 */
		Date startDateAsDate = Date.from(startDate.atStartOfDay().toInstant(ZoneOffset.UTC));
		Date endDateAsDate = Date.from(endDate.atStartOfDay().toInstant(ZoneOffset.UTC));
		
		List<QuestionScore> out = new ArrayList<QuestionScore>();
		
		for (QuestionScore qs : questionScoreRepository.findAll()) {
			if ((qs.getBeginTime().after(startDateAsDate) && qs.getBeginTime().before(endDateAsDate))) {
				out.add(qs);
			}
		}
		return out;
	}
	
	private List<Screening> getScreenings(LocalDate startDate, LocalDate endDate) {
		/*
		 * Overloaded for /getWeeksReport. Returns all screenings scores in a date range.
		 * @return List<QuestionScore>
		 */
		List<Screening> screenings;
		List<Screening> out = new ArrayList<Screening>();
		
		screenings = screeningRepository.findAll();
		
		for (Screening s : screenings) {
			if (s.getEndDateTime().isAfter(startDate) && s.getEndDateTime().isBefore(endDate)) {
				out.add(s);
			}
		}
		return out;
	}
	
	private List<QuestionScore> getQuestionScores(Integer screenerId) {
		/*
		 * Overloaded for /getScreenerReport. Returns all question scores associated with an individual screener.
		 * @return List<QuestionScore>
		 */
		
		List<QuestionScore> out = new ArrayList<QuestionScore>();
		
		for (QuestionScore qs : questionScoreRepository.findAll()) {
			if ((qs.getScreening().getScreenerId() == screenerId)) {
				out.add(qs);
			}
		}
		return out;
	}
	
	private List<Screening> getScreenings(Integer screenerId) {
		/*
		 * Overloaded for /getScreenerReport. Returns all screenings associated with an individual screener.
		 * @return List<QuestionScore>
		 */
		List<Screening> screenings;
		List<Screening> out = new ArrayList<Screening>();
		
		Screener screener = screenerRepository.findById(screenerId).get();
		screenings = screener.getScreenings();
		out = screenings;
		
		return out;
	}
	
	private List<QuestionScore> getQuestionScores() {
		/*
		 * Overloaded for /getTotalReport. Returns all question scores.
		 * @return List<QuestionScore>
		 */
		
		List<QuestionScore> out = new ArrayList<QuestionScore>();
		
		for (QuestionScore qs : questionScoreRepository.findAll()) {
			out.add(qs);
		}
		return out;
	}
	
	private List<Screening> getScreenings() {
		/*
		 * Overloaded for /getTotalReport. Returns all screenings.
		 * @return List<QuestionScore>
		 */
		List<Screening> screenings;
		List<Screening> out = new ArrayList<Screening>();
		screenings = screeningRepository.findAll();
	
		out = screenings;
		
		return out;
	}
	
}




