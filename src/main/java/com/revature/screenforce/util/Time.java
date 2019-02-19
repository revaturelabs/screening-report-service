package com.revature.screenforce.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

/** 
 * Convenience class to select a date based on period, ie WTD, MTD, YTD 
 **/
// http://tutorials.jenkov.com/java-date-time/localdate.html
public class Time {
	private final ZoneId ZONE_ID = ZoneOffset.UTC;
	/**
	 * 
	 * @param numWeeks The number of weeks
	 * @return The start date in UTC numWeeks prior from now
	 */
	public LocalDate getWeekToDate(int numWeeks) {
		return LocalDate.now(ZONE_ID).minusWeeks(numWeeks);
	}
	
	/**
	 * 
	 * @param numMonths The number of months
	 * @return The start date in UTC numMonths prior from now
	 */
	public LocalDate getMonthToDate(int numMonths) {
		return LocalDate.now(ZONE_ID).minusMonths(numMonths);
	}
	
	/**
	 * 
	 * @return The start date in UTC of January 1st of the current year
	 */
	public LocalDate getYearToDate() {
		return LocalDate.of(LocalDate.now(ZONE_ID).getYear(),
				1, 
				1);
	}
}
