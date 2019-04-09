package com.revature.screenforce.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping(value="/printDAOs")
	public void printDAOOutputs() {
		/*
		 * Prints DAO information to the console for debugging purposes.
		 */
		reportsService.printDAOOutputs();
	}
	
	@GetMapping(value="/getReport")
	public String getReport(@RequestParam(name="weeks") String[] weeks, @RequestParam(name="screenerId") Integer screenerId) {
		return reportsService.getReport(weeks, screenerId);
	}

	@GetMapping(value="/getWeeksReport")
	public String getWeeksReport(@RequestParam(name="weeks") String[] weeks) {
		return reportsService.getReport(weeks, null);
	}
	
	@GetMapping(value="/getScreenerReport")
	public String getScreenerReport(@RequestParam(name="screenerId") Integer screenerId) {
		return reportsService.getReport(null, screenerId);
	}
	
	@GetMapping(value="/getTotalReport")
	public String getTotalReport() {
		return reportsService.getReport(null, null);
	}
	
	//to make use of prior group's work -- they used emails rather than id
	@GetMapping(value="/getReportWithEmail")
	public String getReportWithEmail(@RequestParam(name="weeks") String[] weeks, @RequestParam(name="email") String email) {
		Integer screenerId = reportsService.getIdFromEmail(email);
		return reportsService.getReport(weeks, screenerId);
	}
}
