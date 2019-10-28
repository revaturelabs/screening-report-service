package com.revature.screenforce.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.screenforce.services.ReportsService;
import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.beans.Question;
import com.revature.screenforce.beans.QuestionScore;
import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SkillType;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.beans.ViolationType;
import com.revature.screenforce.beans.Weight;
import com.revature.screenforce.models.FullReportModel;

@RestController
@CrossOrigin
public class ReportsController {

	@Autowired ReportsService reportsService;
	
	@GetMapping(value="/bucket", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Bucket> getAllBucket(){
		return this.reportsService.testGetAllBuckets();
	}
	@GetMapping(value="/question", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Question> getAllQuestion(){
		return this.reportsService.testGetAllQuestion();
	}
	
	@GetMapping(value="/scheduledscreening", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ScheduledScreening> getAllScheduledScreening(){
		return this.reportsService.testGetAllScheduledScreening();
	}
	
	@GetMapping(value="/questionscore", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<QuestionScore> getAllQuestionScores(){
		return this.reportsService.testGetAllQuestionScore();
	}
	
	@GetMapping(value="/questionscore/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<QuestionScore> getAllScoresByScreeningId(@PathVariable Integer id){
		return this.reportsService.testGetScoresByScreeningId(id);
	}

	@GetMapping(value="/screening", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Screening> getAllScreening(){
		return this.reportsService.testGetAllScreening();
	}
	
	@GetMapping(value="/skilltype", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SkillType> getAllSkillType(){
		return this.reportsService.testGetAllSkillType();
	}

	@GetMapping(value="/softskillviolation", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SoftSkillViolation> getAllSoftSkillViolation(){
		return this.reportsService.testGetAllSoftSkillViolation();
	}

	@GetMapping(value="/violationtype", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ViolationType> getAllViolationType(){
		return this.reportsService.testGetAllViolationType();
	}

	@GetMapping(value="/weight", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Weight> getAllWeight(){
		return this.reportsService.testGetAllWeight();
	}
	@GetMapping(value="/frm", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FullReportModel getFullReport(){
		return this.reportsService.testFullReport();
	}


//	@GetMapping(value="/email", produces= MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<String> getAllEmails(@RequestParam(value = "email") String email){
//		List<String> emails = this.reportsService.getAllEmails(email);
//		return emails;
//	}
//
//	@GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
//	public String getReports(
//			@RequestParam(name="weeks") 
//			String weeks, 
//			@RequestParam(name="email", required=false)
//			String email) {
//		return reportsService.getReport(email, weeks);
//	}
}
