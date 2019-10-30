package com.revature.screenforce.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.Track;
import com.revature.screenforce.feign.FeignScreening;
import com.revature.screenforce.feign.FeignTrack;
import com.revature.screenforce.models.SimpleReportModel;
import com.revature.screenforce.services.ReportsService;
@EnableFeignClients
@SpringBootTest
@RunWith(SpringRunner.class)
public class testReportService {
	@Mock
	FeignScreening feignScreening;
	@Mock
	FeignTrack feignTrack;

	@InjectMocks
	ReportsService rsMock;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	
	}
	@Test
	public void testSRM() {
		//creates a simpleReportModel from screening 4321
	//	when(rsMock.createTestSimpleModel().getScreeningId()).thenReturn(4321);
		//when(rsMock.createTestSimpleModel().getScreeningId()).thenReturn(4321);
	}
	@Test
	public void testFRM() {
		when(rsMock.createFullReportModel(4321).getCan().getName()).thenReturn("");
		}
//	@Test
//	public void test() throws ParseException {
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//		Date start = sf.parse("2018-03-01");
//		Date end = sf.parse("2018-03-09");
//		List<SimpleReportModel> out = rsMock.getSimpleReportModelByRange(start, end);
//		Assert.assertEquals(null, out);
//		System.out.println("here");
//		for(SimpleReportModel i : out) {
//			System.out.println(i.toString());
//		}
//	}
}
