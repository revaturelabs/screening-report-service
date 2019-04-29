package com.revature.screenforce.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.beans.Question;
import com.revature.screenforce.controllers.QuestionController;
import com.revature.screenforce.services.BucketClient;
import com.revature.screenforce.services.QuestionClient;
import com.revature.screenforce.services.ReportsService;
//import com.revature.screenforce.services.ReportsService.Tallies;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerMockTest {

	@Mock
	QuestionClient qClient; 
	@Mock
	BucketClient bClient;
	@InjectMocks
	QuestionController qc;
	
	@Mock
	QuestionClient qsClient;
	@InjectMocks
	ReportsService rs;
	
//    @Mock
//    QuestionServiceImpl questionService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllQuestions() {
		Question question = new Question();
		when(qClient.getAllQuestions()).thenReturn(new ArrayList<Question>(Arrays.asList(question)));
		List<Question> questions = qc.getQuestions();
		System.out.println(questions.size());
		assertTrue(questions.size() > 0);
		
	}
	
	@Test
	public void testPostQuestion() {
		when(bClient.getBucketById(0)).thenReturn(new Bucket());
		when(qClient.createQuestion(new Question())).thenReturn(new Question());
		Question question = qc.postQuestion("Test Question");
		System.out.println(question+"ttttt");
		assertTrue(question != null);
	}

	@Test
	public void testGetHardestQuestions() {
		when(qsClient.getQuestionById(0)).thenReturn(new Question());
		
		//List<Question> hardestQuestions = rs.hardestQuestions().;
//		when(qClient.createQuestion(new Question())).thenReturn(new Question());
		
		//assertTrue(question != null);
	}


}