package com.revature.screenforce.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.screenforce.services.ReportsService;
import com.revature.screenforce.models.FullReportModel;
import com.revature.screenforce.models.SimpleReportModel;
/**
 * The Main Controller for screening-report-service
 * Exposed 1 main endpoint to be consumed
 * called : getFullReportByDate
 * also exposes 2 tester end points to support for the Front End team
 * Will be commented out once support is no longer needed
 * called : getAFullReport, gettestFullReport
 * Also contains commented out end points for feign testing
 * Not used externally, just didn't want to delete anything
 * 
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
@RestController
@CrossOrigin
public class ReportsController {

	@Autowired ReportsService reportsService;

	@GetMapping(value="/frmtest", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FullReportModel getTestFullReportModel(){
		return this.reportsService.createFullReportModel(4321);
	}

	@GetMapping(value="/frm/{screeningId}", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FullReportModel getTestFullReportModelByScreeningId(@PathVariable int screeningId){
		return this.reportsService.createFullReportModel(screeningId);
	}
	
	@GetMapping(value="/srm", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SimpleReportModel> getAllSimpleReportModel(){
		LocalDate currentDate = LocalDate.now(); 
		LocalTime currentTime = LocalTime.now();
		LocalDateTime end = LocalDateTime.of(currentDate, currentTime);
		

		LocalDateTime start = LocalDateTime.of(1970,1,1,1,1);;
		return this.reportsService.getSimpleReportModelByRange(start, end);	

	}
	
	@GetMapping(value="/srm/{dateStart}/{dateEnd}", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SimpleReportModel> getSimpleReportModelByRange(@PathVariable String dateStart,@PathVariable String dateEnd){
	
		Date start;
		Date end;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			start = sf.parse(dateStart);
			c.setTime(start);
			c.add(Calendar.DATE, -2);
			Date searchStart = sf.parse(sf.format(c.getTime()));
			end = sf.parse(dateEnd);
			c.setTime(end);
			c.add(Calendar.DATE, 0);
			Date searchEnd = sf.parse(sf.format(c.getTime()));
			LocalDateTime ss = LocalDateTime.of(searchStart.getYear(),searchStart.getMonth(),searchStart.getDay(),0,0);
			LocalDateTime se = LocalDateTime.of(searchEnd.getYear(),searchEnd.getMonth(),searchEnd.getDay(),0,0);
			return this.reportsService.getSimpleReportModelByRange(ss,se);	
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		return null;

	}
	
}
