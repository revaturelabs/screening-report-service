package com.revature.screenforce.controllers;

import java.time.LocalDate;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.revature.screenforce.beans.QuestionScore;
//import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.dtos.Screening;
import com.revature.screenforce.dtos.SimpleQuestionScore;
//import com.revature.screenforce.dtos.SoftSkillViolation;
import com.revature.screenforce.dtos.ViolationType;
import com.revature.screenforce.services.ReportsService;
//import com.revature.screenforce.beans.SimpleQuestionScore;
import com.revature.screenforce.beans.SoftSkillViolation;
//import com.revature.screenforce.beans.ViolationType;
//import com.revature.screenforce.services.ReportsService;
import com.revature.screenforce.services.ScreeningQuestionScoreClient;
import com.revature.screenforce.services.ScreeningScreeningClient;
import com.revature.screenforce.services.ScreeningViolationClient;

@RestController
@CrossOrigin
@EnableFeignClients //JU
public class ReportsController {
	/*
	 * This controller is built to work with screening-ui, generating reports for the Reports tab there.
	 * Screeners are identified by email on the client side, but Id on the backend, so we have a special
	 * function to handle emails.
	 */

	//variables - services to be injected in methods 
	//services for internal data
	@Autowired ReportsService reportsService;
	//services for external data 
	@Autowired ScreeningViolationClient screeningVClient; 
	@Autowired ScreeningQuestionScoreClient screeningQSClient; 
	@Autowired ScreeningScreeningClient screeningSClient; 

	//methods
	
	//5/28 JU - commenting out unless needed by front end. 
	/*
	@GetMapping(value="/getEmails", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> getAllEmails(@RequestParam(value = "email") String email){
		List<String> emails = this.reportsService.getAllEmails(email);
		return emails;
	}
	*/
	//5/28 JU 
	@GetMapping(value="/screenings")
	public List<Screening> getAllScreenings() {
		return this.reportsService.getAllScreenings();
	} 

	//5/28 JU
	@GetMapping(value="/softskillviolations")
	public List<com.revature.screenforce.dtos.SoftSkillViolation> getAllSoftSkillViolations() {
		return this.reportsService.getAllSoftSkillViolations();
	}
	
	//5/26 JU - adding this for testing only. Works to pull from screening service w/ feign client. 
	@GetMapping(value="/violationTypes")
	public List<ViolationType> getAllViolationTypes() {
		return screeningVClient.getViolationTypes();
	}
	
	
	//5/28 JU  - working on this one.
	@GetMapping(value="/questionscores")
	public List<SimpleQuestionScore> getAllQuestionScores() {
		return this.reportsService.getAllQuestionScores();
	}

	
	//5/26 JU Adding this to pull from screening service w/ feign client. For testing only. Needs to be tested.
	@GetMapping(value="/scores/{screeningId}")
	public SimpleQuestionScore getScoresByScreeningId(@PathVariable int screeningId) {
		return screeningQSClient.getScoresByScreeningId(screeningId);
		
	}
	
	/*
	@GetMapping(value="/getReport")
	public String getReport(@RequestParam(name="startDate") String startDate, @RequestParam(name = "endDate") String endDate, @RequestParam(name="screenerId") Integer screenerId) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		return reportsService.getReport(start, end, screenerId);
	}

	
	@GetMapping(value="/getTotalReport")
	public String getTotalReport() {
		return reportsService.getReport();
	}
	
	@GetMapping(value="/getWeeksReport")
	public String getWeeksReport2(@RequestParam(name="startDate") String startDate, @RequestParam(name = "endDate") String endDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		return reportsService.getReport(start, end);
	}
	
	@GetMapping(value="/getScreenerReport")
	public String getScreenerReport(@RequestParam(name="screenerId") Integer screenerId) {
		return reportsService.getReport(screenerId);
	}
	 
	
	//to make use of prior group's work -- they used emails rather than id
	@GetMapping(value="/getReportWithEmail")
	public String getReportWithEmail(@RequestParam(name="startDate") String startDate, @RequestParam(name = "endDate") String endDate, @RequestParam(name="email") String email) {
		Integer screenerId = reportsService.getIdFromEmail(email);
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		return reportsService.getReport(start, end, screenerId);
	}
	*/
}
