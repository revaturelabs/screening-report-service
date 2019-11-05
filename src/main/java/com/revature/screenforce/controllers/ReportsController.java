package com.revature.screenforce.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.screenforce.services.ReportsService;
import com.revature.screenforce.models.FullReportModel;
import com.revature.screenforce.models.SimpleReportModel;

/**
 * The Main Controller for screening-report-service Exposed 1 main endpoint to
 * be consumed called : getFullReportByDate also exposes 2 tester end points to
 * support for the Front End team Will be commented out once support is no
 * longer needed called : getAFullReport, gettestFullReport Also contains
 * commented out end points for feign testing Not used externally, just didn't
 * want to delete anything
 * 
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */
@RestController

public class ReportsController {

	@Autowired
	ReportsService reportsService;

//	@GetMapping(value = "/frmtest", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody FullReportModel getTestFullReportModel() {
//		return this.reportsService.createFullReportModel(4321);
//	}

	@GetMapping(value = "/frm/{screeningId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FullReportModel getFullReportModelByScreeningId(@PathVariable int screeningId) {
		return this.reportsService.createFullReportModel(screeningId);
	}

	@GetMapping(value = "/srm", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SimpleReportModel> getAllSimpleReportModel() {
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		LocalDateTime end = LocalDateTime.of(currentDate, currentTime);

		LocalDateTime start = LocalDateTime.of(1970, 1, 1, 1, 1);
		;
		return this.reportsService.getSimpleReportModelByRange(start, end);

	}

	@GetMapping(value = "/srm/{dateStart}/{dateEnd}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SimpleReportModel> getSimpleReportModelByRange(@PathVariable String dateStart,
			@PathVariable String dateEnd) {

		String[] start = dateStart.split("-");
		String[] end = dateEnd.split("-");
		LocalDateTime ss;
		LocalDateTime se;
		try {
			ss = LocalDateTime.of(Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]), 0,
					0);
			ss = ss.minusDays(2);
		} catch (Exception e1) {
			ss = LocalDateTime.of(1970, 1, 1, 0, 0);
			e1.printStackTrace();
		}
		try {
			se = LocalDateTime.of(Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]), 0, 0);
		} catch (Exception e1) {
			se = LocalDateTime.now();
			e1.printStackTrace();
		}
		System.out.println(ss.toLocalDate().toString() + "\n" + se.toLocalDate().toString());
		return this.reportsService.getSimpleReportModelByRange(ss, se);

	}
}
