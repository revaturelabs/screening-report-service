package com.revature.screenforce.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@GetMapping(value="/srmtest", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FullReportModel getTestSimpleReportModel(){

	//	return this.reportsService.getAllReports(start, end);
		return null;
	}
	
	@GetMapping(value="/srm", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SimpleReportModel> getAllSimpleReportModel(){
		Date start = new Date(0);
		Date end = new Date();
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
			return this.reportsService.getSimpleReportModelByRange(searchStart, searchEnd);	
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		return null;

	}
	/**
	 * A testing end point for the Front End team to use 
	 * screening id 4321, is the first entry from the test DB.
	 * returns 1 fully completed FullReportModel
	 * used for testing only
	 * @return FullReportModel : 

	@GetMapping(value="/frm", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FullReportModel getAFullReport(){
		return this.reportsService.testFullReport(new Integer(4321));
	}
	*/
	/**
	 * A testing end point for the Front End team to use
	 * Returns all the fully complete FullReportModels from the DB
	 * checks if ScheduledStatus is "screened" to determine completion
	 * @return List<FullReportModel> :
	 *
	@GetMapping(value="/frmtest", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FullReportModel> gettestFullReport(){
		Date end = null;
		
		Date start = null;

		return this.reportsService.getAllReports(start, end);
		
	}
	*/
	/**
	 * The Main end point for consumption. Recieves 2 inputs with get request
	 * preconditions:
	 * 	Both value must not be null
	 * 	dateStart must be before dateEnd
	 * 	Formatting of Dates: "yyyy-MM-dd" eg: 2018-03-01
	 * 
	 * @param dateStart String with correct formated date 
	 * @param dateEnd	String with correct formated date
	 * @return List<FullReportModel> with the scheduleDate between the start
	 * and end date inclusively

	@GetMapping(value="/frm/{dateStart}/{dateEnd}", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FullReportModel> getFullReportByDate(@PathVariable String dateStart,@PathVariable String dateEnd){

	
		Date start;
		Date end;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();

		//return dateStart;
		try {
			start = sf.parse(dateStart);
		//	LocalDateTime temp = start.toInstant();
		
			c.setTime(start);
			c.add(Calendar.DATE, -1);
			Date searchStart = sf.parse(sf.format(c.getTime()));
			
			
			end = sf.parse(dateEnd);
			c.setTime(end);
			c.add(Calendar.DATE, 1);
			Date searchEnd = sf.parse(sf.format(c.getTime()));
			
			//LocalDateTime.from(end.toInstant()).plusDays(1);
			return this.reportsService.getAllReports(searchStart,searchEnd);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		return null;
	
	}
	 */
}
