package com.revature.screenforce.controller;

import static org.hamcrest.Matchers.hasItems;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.View;

import com.revature.screenforce.beans.Candidate;
import com.revature.screenforce.beans.Category;
import com.revature.screenforce.beans.Question;
import com.revature.screenforce.beans.QuestionScore;
import com.revature.screenforce.beans.ScheduledScreening;
import com.revature.screenforce.beans.ScheduledStatus;
import com.revature.screenforce.beans.Screening;
import com.revature.screenforce.beans.SoftSkillViolation;
import com.revature.screenforce.beans.Track;
import com.revature.screenforce.beans.ViolationType;
import com.revature.screenforce.beans.Weight;
import com.revature.screenforce.controllers.ReportsController;
import com.revature.screenforce.models.FullReportModel;
import com.revature.screenforce.models.SimpleReportModel;
import com.revature.screenforce.services.ReportsService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ReportsControllerTest {


@Mock
ReportsService reportsService;

@InjectMocks
ReportsController reportsController;

Screening screening;

SimpleReportModel srm;
Track track;
Category testCategory;
Weight testWeight;
Question testQuestion;
QuestionScore testScore;
SoftSkillViolation testViolation;
@Autowired
private WebApplicationContext webApplicationContext;
 private MockMvc mockMvc;

@Before
public void setup() {
	MockitoAnnotations.initMocks(this);
//	RestAssuredMockMvc.standaloneSetup(reportsController);
//	RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	mockMvc = MockMvcBuilders.standaloneSetup(reportsController).build();
		
	LocalDateTime screenDate = LocalDateTime.of(2018, 1,1,0,0);
	screening = new Screening(123, new ScheduledScreening(123, new Candidate(), ScheduledStatus.SCREENED,
			51, screenDate), 123, 51,
			4.0, "Me", "Good", "Good Eye-Contact",
			screenDate.minusDays(1), null, true, "SCREENED");
	track = new Track(51, "test", true);
	srm = new SimpleReportModel(screening, track);
	testScore = new QuestionScore(12, 12, 12, screening, 4.0,
		"Good", screenDate);
    testCategory = new Category(12, "Java", true);
    testWeight = new Weight(12, 12, track, testCategory);
    testQuestion = new Question(12, testCategory, true, "What is Java?", "The answer to life.");
    testViolation = new SoftSkillViolation(123, screening, new ViolationType(),
			"No Violations", screenDate);
    
}
@Test
public void testFRM() throws Exception {

	Mockito.when(reportsService.createFullReportModel(123)).thenReturn(new FullReportModel(srm));
	RequestBuilder  requestBuilder = MockMvcRequestBuilders.get("/frm/123");
	mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.jsonPath("srm.screeningId").value(new Integer(123)));
	 }

//@Test
//public void testSingleFRM() {
//	MockHttpServletRequest request = new MockHttpServletRequest();
//	RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//	
//	frm = reportController.getTestFullReportModel();
//	Assert.assertTrue(frm.getScreener_id()==3);
//}
//
//		@Test
//		public void testSingleFRM() {
//			 given().
//			    when().
//			        get("http://localhost:8185/frmtest/").
//			    then().
//			        assertThat().
//			        statusCode(200).
//			    and().
//			    	assertThat().
//			    	body("screener_id", equalTo(3)).
//			    and().
//			    	assertThat().
//			    	body("srm.screeningId",equalTo(4321));
//		}
//		@Test
//		public void testFRMById() {
//			 given().
//			    when().
//			        get("http://localhost:8185/frm/4323").
//			    then().
//			        assertThat().
//			        statusCode(200).
//			    and().
//			    	assertThat().
//			    	body("screener_id", equalTo(4)).
//			    and().
//			    	assertThat().
//			    	body("srm.screeningId",equalTo(4323));
//		}
//		@Test
//		public void testSRMDates() {
//			 given().
//			    when().
//			        get("http://localhost:8185/srm/2018-03-05/2018-03-09").
//			    then().
//			        assertThat().
//			        statusCode(200).
//			    and().
//			    	assertThat().
//			    	body("screeningId", hasItems(4323, 4325)).
//			    and().
//			    	assertThat().
//			    	body("track.trackId",hasItems(51, 52));
//			 }

}
