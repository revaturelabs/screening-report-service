package com.revature.screenforce.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

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
import com.revature.screenforce.feign.FeignCategory;
import com.revature.screenforce.feign.FeignQuestion;
import com.revature.screenforce.feign.FeignQuestionScore;
import com.revature.screenforce.feign.FeignScreening;
import com.revature.screenforce.feign.FeignSoftSkillViolation;
import com.revature.screenforce.feign.FeignTrack;
import com.revature.screenforce.feign.FeignWeight;
import com.revature.screenforce.models.SimpleReportModel;
import com.revature.screenforce.services.ReportsService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReportsServiceTest {
	@Mock
	FeignScreening fsMock;
	@Mock
	FeignTrack ftMock;
	@Mock
	FeignQuestionScore fqMock;
	@Mock
	FeignCategory fcMock;
	@Mock
	FeignWeight fwMock;
	@Mock
	FeignQuestion fqtMock;
	@Mock
	FeignSoftSkillViolation fsvMock;

	@InjectMocks
	ReportsService reportService;
	Screening screening;
	SimpleReportModel srm;
	Track track;
	Category testCategory;
	Weight testWeight;
	Question testQuestion;
	QuestionScore testScore;
	SoftSkillViolation testViolation;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		LocalDateTime currentDate = LocalDateTime.now();
		screening = new Screening(123,
				new ScheduledScreening(123, new Candidate(), ScheduledStatus.SCREENED, 51, currentDate), 123, 51, 4.0,
				"Me", "Good", "Good Eye-Contact", currentDate.minusDays(1), null, true, "SCREENED");
		track = new Track(51, "test", true);
		srm = new SimpleReportModel(screening, track);
		testScore = new QuestionScore(12, 12, 12, screening, 4.0, "Good", currentDate);
		testCategory = new Category(12, "Java", true);
		testWeight = new Weight(12, 12, track, testCategory);
		testQuestion = new Question(12, testCategory, true, "What is Java?", "The answer to life.");
		testViolation = new SoftSkillViolation(123, screening, new ViolationType(), "No Violations", currentDate);
	}

	@Test
	public void testCreateSimpleModel() {
		when(ftMock.getTrackById(anyInt())).thenReturn(track);
		assertEquals(track, reportService.createSimpleModel(screening).getTrack());
	}

	@Test
	public void testGetSimpleReportModelByRange() {
		List<Screening> testList = new ArrayList<>();
		testList.add(screening);
		when(fsMock.getAllScreening()).thenReturn(testList);
		System.out.println(screening.getStartDateTime());
		assertEquals(1, reportService.getSimpleReportModelByRange(screening.getStartDateTime().minusDays(1),
				screening.getStartDateTime().plusDays(1)).size());
	}

	@Test
	public void testCreateFullReportModel() {
		List<QuestionScore> testQList = new ArrayList<>();
		testQList.add(testScore);
		List<SoftSkillViolation> testVList = new ArrayList<>();
		testVList.add(testViolation);
		when(fsMock.getScreeningById(anyInt())).thenReturn(screening);
		when(fqMock.getScoresByScreeningId(anyInt())).thenReturn(testQList);
		when(fcMock.getCategoryByCategoryId(anyInt())).thenReturn(testCategory);
		when(fwMock.getWeightFromIds(anyInt(), anyInt())).thenReturn(testWeight);
		when(fqtMock.getQuestionById(anyInt())).thenReturn(testQuestion);
		when(fsvMock.getSoftSkillViolations()).thenReturn(testVList);
		assertEquals(srm, reportService.createFullReportModel(123).getSrm());
	}

}
