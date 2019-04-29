package com.revature.screenforce.controllers;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.screenforce.beans.QuestionScore;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.services.ReportsService;

@RestController
@CrossOrigin
public class ReportsController {
	/*
	 * This controller is built to work with screening-ui, generating reports for the Reports tab there.
	 * Screeners are identified by email on the client side, but Id on the backend, so we have a special
	 * function to handle emails.
	 */

	@Autowired ReportsService reportsService;

	@GetMapping(value="/getEmails", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> getAllEmails(@RequestParam(value = "email") String email){
		List<String> emails = this.reportsService.getAllEmails(email);
		return emails;
	}
	
	@GetMapping(value="/screenings")
	public List<Screening> getAllScreenings() {
		return this.reportsService.getAllScreenings();
	} 
	
	@GetMapping(value="/softskillviolations")
	public List<SoftSkillViolation> getAllSoftSkillViolations() {
		return this.reportsService.getAllSoftSkillViolations();
	}
	
	@GetMapping(value="/questionscores")
	public List<QuestionScore> getAllQuestionScores() {
		return this.reportsService.getAllQuestionScores();
	}
	
	//Date format = yyyy-mm-dd
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
	
    @GetMapping(value="/getReportWithEmail")
    public String getReportWithEmail(@RequestParam(name="startDate") String startDate, @RequestParam(name = "endDate") String endDate, @RequestParam(name="email") String email) {
        Integer screenerId = reportsService.getIdFromEmail(email);
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return reportsService.getReport(start, end, screenerId);
    }
}
