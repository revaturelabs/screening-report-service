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
	
	//getReport
	public String getReport(LocalDate startDate, LocalDate endDate, Integer screenerId) {
		Integer numApplicantsPassed;
		Integer numApplicantsFailed;
		
		List<Screening> screenings = getScreenings(startDate, endDate, screenerId);
		List<ReportData.BarChartData> violationsByType = violationsByType(screenings);
		List<QuestionScore> questionScores = getQuestionScores(startDate, endDate, screenerId);
		Tallies tallies = tallyScores(questionScores);
		List<ReportData.BarChartData> avgBucketTypeScore = avgBucketTypeScore(tallies);
		List<ReportData.BarChartData> avgSkillTypeScore = avgSkillTypeScore(tallies);
		List<String> hardestQuestions = hardestQuestions(tallies);
		
		Screener tempScreener = screenerRepository.findById(screenerId).get();
		ReportData.Screener screener = new ReportData.Screener(tempScreener.getName(), tempScreener.getEmail());
			
		numApplicantsPassed = numApplicantsPassed(screenings);
		numApplicantsFailed = numApplicantsFailed(screenings);
		
		//Method 
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
	
	//weeksReport
	public String getReport(LocalDate startDate, LocalDate endDate) {
		Integer numApplicantsPassed;
		Integer numApplicantsFailed;
		ReportData.Screener screener = null;
		
		List<Screening> screenings = getScreenings(startDate, endDate);
		List<ReportData.BarChartData> violationsByType = violationsByType(screenings);
		List<QuestionScore> questionScores = getQuestionScores(startDate, endDate);
		Tallies tallies = tallyScores(questionScores);
		List<ReportData.BarChartData> avgBucketTypeScore = avgBucketTypeScore(tallies);
		List<ReportData.BarChartData> avgSkillTypeScore = avgSkillTypeScore(tallies);
		List<String> hardestQuestions = hardestQuestions(tallies);
			
		numApplicantsPassed = numApplicantsPassed(screenings);
		numApplicantsFailed = numApplicantsFailed(screenings);
		
		//Method 
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
	
	//getScreenerReport
		public String getReport(Integer screenerId) {
			Integer numApplicantsPassed;
			Integer numApplicantsFailed;
			
			List<Screening> screenings = getScreenings(screenerId);
			List<ReportData.BarChartData> violationsByType = violationsByType(screenings);
			List<QuestionScore> questionScores = getQuestionScores(screenerId);
			Tallies tallies = tallyScores(questionScores);
			List<ReportData.BarChartData> avgBucketTypeScore = avgBucketTypeScore(tallies);
			List<ReportData.BarChartData> avgSkillTypeScore = avgSkillTypeScore(tallies);
			List<String> hardestQuestions = hardestQuestions(tallies);
			
			//In null screenerId, just pass null
			Screener tempScreener = screenerRepository.findById(screenerId).get();
			ReportData.Screener screener = new ReportData.Screener(tempScreener.getName(), tempScreener.getEmail());
				
			numApplicantsPassed = numApplicantsPassed(screenings);
			numApplicantsFailed = numApplicantsFailed(screenings);
			
			//Method 
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
		
		//getTotalReport
		public String getReport() {
			Integer numApplicantsPassed = 0;
			Integer numApplicantsFailed = 0;
			
			List<Screening> screenings = getScreenings();
			List<ReportData.BarChartData> violationsByType = violationsByType(screenings);
			List<QuestionScore> questionScores = getQuestionScores();
			Tallies tallies = tallyScores(questionScores);
			List<ReportData.BarChartData> avgBucketTypeScore = avgBucketTypeScore(tallies);
			List<ReportData.BarChartData> avgSkillTypeScore = avgSkillTypeScore(tallies);
			List<String> hardestQuestions = hardestQuestions(tallies);
			
			//In null screenerId, just pass null
			ReportData.Screener screener = null;
				
			numApplicantsPassed = numApplicantsPassed(screenings);
			numApplicantsFailed = numApplicantsFailed(screenings);
			
			//Method 
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
	
	private List<String> hardestQuestions(Tallies tallies){
		Map<Integer, Double> avgScoreQuestion = new HashMap<>();
		for (Integer qid : tallies.sumScoresQuestion.keySet()) {
			avgScoreQuestion.put(qid, tallies.sumScoresQuestion.get(qid) / (double) tallies.countQuestion.get(qid));
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
			for (Integer qid : keyList.subList(0, 5)) {
				tempHardestQuestions.add(questionDAO.findById(qid).get().getQuestionText());
			}
			hardestQuestions = tempHardestQuestions;
		}
		return hardestQuestions;	
	}
	
	private List<ReportData.BarChartData> avgSkillTypeScore(Tallies tallies ){
		List<ReportData.BarChartData> avgSkillTypeScore = new ArrayList<BarChartData>();
		for (Integer stid : tallies.sumScoresSkillType.keySet()) {
			avgSkillTypeScore.add(new ReportData.BarChartData(
					skillTypeDAO.findById(stid).get().getTitle(),
					tallies.sumScoresSkillType.get(stid) / (double) tallies.countSkillType.get(stid)
					));
		}
		return avgSkillTypeScore;	
	}
	
	private List<ReportData.BarChartData> avgBucketTypeScore(Tallies tallies){
		List<ReportData.BarChartData> avgBucketTypeScore = new ArrayList<BarChartData>();
		for (Integer bid : tallies.sumScoresBucket.keySet()) {
			avgBucketTypeScore.add(new ReportData.BarChartData(
					bucketDAO.findById(bid).get().getBucketDescription(),
					tallies.sumScoresBucket.get(bid) / (double) tallies.countBucket.get(bid)
					));
		}
		return avgBucketTypeScore;
	}
	private List<ReportData.BarChartData> violationsByType(List<Screening> screenings){
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
		Integer numApplicantsPassed = 0;
		for (Screening s : screenings) {
            double compScore = s.getCompositeScore();
            if (compScore > 70) {
                numApplicantsPassed +=1;
            }
        }
		return numApplicantsPassed;
	}
	private Integer numApplicantsFailed(List<Screening> screenings) {
		Integer numApplicantsFailed = 0;
		for (Screening s : screenings) {
            double compScore = s.getCompositeScore();
            if (compScore < 70) {
                numApplicantsFailed +=1;
            }
        }
		return numApplicantsFailed;
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
	
	private List<QuestionScore> getQuestionScores(LocalDate startDate, LocalDate endDate, Integer screenerId) {
		/*
		 * Returns all question scores in a date range associated with an individual screener.
		 * Setting screener or date params to null will ignore that constraint.  Note that setting either
		 * date param to null means date is ignored completely.
		 * @return List<QuestionScore>
		 */
		
		// convenience changing from LocalDate to Date. Different pieces in different formats :|
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
	private List<QuestionScore> getQuestionScores(LocalDate startDate, LocalDate endDate) {
		/*
		 * Returns all question scores in a date range associated with an individual screener.
		 * Setting screener or date params to null will ignore that constraint.  Note that setting either
		 * date param to null means date is ignored completely.
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
	private List<QuestionScore> getQuestionScores(Integer screenerId) {
		/*
		 * Returns all question scores in a date range associated with an individual screener.
		 * Setting screener or date params to null will ignore that constraint.  Note that setting either
		 * date param to null means date is ignored completely.
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
	private List<QuestionScore> getQuestionScores() {
		/*
		 * Returns all question scores in a date range associated with an individual screener.
		 * Setting screener or date params to null will ignore that constraint.  Note that setting either
		 * date param to null means date is ignored completely.
		 * @return List<QuestionScore>
		 */
		
		List<QuestionScore> out = new ArrayList<QuestionScore>();
		
		for (QuestionScore qs : questionScoreRepository.findAll()) {
			out.add(qs);
		}
		return out;
	}
	
	//getReport
	private List<Screening> getScreenings(LocalDate startDate, LocalDate endDate, Integer screenerId) {
		
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
	
	//getWeeksReport
	private List<Screening> getScreenings(LocalDate startDate, LocalDate endDate) {
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
	
	//getScreenerReport
	private List<Screening> getScreenings(Integer screenerId) {
		
		List<Screening> screenings;
		List<Screening> out = new ArrayList<Screening>();
		
		Screener screener = screenerRepository.findById(screenerId).get();
		screenings = screener.getScreenings();
		out = screenings;
		
		return out;
	}
	
	//getTotalReport
	private List<Screening> getScreenings() {
		List<Screening> screenings;
		List<Screening> out = new ArrayList<Screening>();
		screenings = screeningRepository.findAll();
	
		out = screenings;
		
		return out;
	}
	
}




