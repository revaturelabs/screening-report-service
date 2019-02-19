package com.revature.screenforce.time;

import java.time.LocalDate;
import java.time.ZoneOffset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.screenforce.util.Time;


public class TestTime {
	private Time time;
	
	@Before
	public void init() {
		time = new Time();
	}
	
	@Test
	public void testWeekBefore() {
		LocalDate today = LocalDate.now(ZoneOffset.UTC);
		Assert.assertEquals(today.minusWeeks(1), time.getWeekToDate(1));
		Assert.assertEquals(today.minusMonths(1), time.getMonthToDate(1));
		Assert.assertEquals(LocalDate.of(today.getYear(), 1, 1), time.getYearToDate());
	}
}
