package com.revature.screenforce.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ReportsControllerTest {

	@Mock
	private ReportsService reportsService;
	@InjectMocks
	private ReportsController reportsController;

	private Screening screening;
	private SimpleReportModel srm;
	private Track track;
	private Category testCategory;
	private Weight testWeight;
	private Question testQuestion;
	private QuestionScore testScore;
	private SoftSkillViolation testViolation;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(reportsController).build();

		LocalDateTime screenDate = LocalDateTime.of(2018, 1, 1, 0, 0);
		screening = new Screening(123,
				new ScheduledScreening(123, new Candidate(), ScheduledStatus.SCREENED, 51, screenDate), 123, 51, 4.0,
				"Me", "Good", "Good Eye-Contact", screenDate.minusDays(1), null, true, "SCREENED");
		track = new Track(51, "test", true);
		srm = new SimpleReportModel(screening, track);
		testScore = new QuestionScore(12, 12, 12, screening, 4.0, "Good", screenDate);
		testCategory = new Category(12, "Java", true);
		testWeight = new Weight(12, 12, track, testCategory);
		testQuestion = new Question(12, testCategory, true, "What is Java?", "The answer to life.");
		testViolation = new SoftSkillViolation(123, screening, new ViolationType(), "No Violations", screenDate);
	}

	@Test
	public void testGetFullReportModelByScreeningId() throws Exception {
		Mockito.when(reportsService.createFullReportModel(123)).thenReturn(new FullReportModel(srm));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/frm/123");
		mockMvc.perform(requestBuilder)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("srm.screeningId").value(new Integer(123)))
			.andExpect(MockMvcResultMatchers.jsonPath("srm.track.trackId").value(new Integer(51)));
	}

	@Test
	public void testGetAllSimpleReportModel() throws Exception {
		List<SimpleReportModel> lsrm = new ArrayList<SimpleReportModel>();
		lsrm.add(srm);
		Mockito.when(reportsService.getSimpleReportModelByRange(any(), any())).thenReturn(lsrm);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/srm");
		mockMvc.perform(requestBuilder)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].screeningId").value(new Integer(123)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].track.trackId").value(new Integer(51)));
	}
	
	@Test
	public void testGetSimpleReportModelByRange() throws Exception {
		List<SimpleReportModel> lsrm = new ArrayList<SimpleReportModel>();
		lsrm.add(srm);
		Mockito.when(reportsService.getSimpleReportModelByRange(any(), any())).thenReturn(lsrm);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/srm/2018-01-01/2019-01-01");
		mockMvc.perform(requestBuilder)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].screeningId").value(new Integer(123)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].track.trackId").value(new Integer(51)));
	}
}
