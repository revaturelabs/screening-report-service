package com.revature.screenforce.testerdriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.Track;
import com.revature.screenforce.feign.FeignScreening;
import com.revature.screenforce.models.SimpleReportModel;
import com.revature.screenforce.services.ReportsService;
@SpringBootTest
@RunWith(SpringRunner.class)
public class tester {
	@Mock
	FeignScreening feignScreening;
	@InjectMocks
	ReportsService rsMock;
	 

@Test
public void test2() {
	Screening src = rsMock.feignScreening.getScreeningById(4321);
	Assert.assertEquals(src, null);
}
	@Test
	public void test() throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = sf.parse("2018-03-01");
		Date end = sf.parse("2018-03-09");
		List<SimpleReportModel> out = rsMock.getSimpleReportModelByRange(start, end);
		Assert.assertEquals(null, out);
		System.out.println("here");
		for(SimpleReportModel i : out) {
			System.out.println(i.toString());
		}
	}
}
