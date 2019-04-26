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

import com.revature.screenforce.beans.Question;
import com.revature.screenforce.controllers.QuestionController;
import com.revature.screenforce.services.QuestionClient;


import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

//@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerMockTest {

	@Mock
	QuestionClient qClient; 
	@InjectMocks
	QuestionController qc;
//    @Mock
//    QuestionServiceImpl questionService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllQuestions() {
		
		//when(qclient.getAllQuestions()).thenReturn(new ArrayList<Question>(Arrays.asList()));

		//int before = qclient.getAllQuestions().size();
		//List<Question> questions = questionClient.getAllQuestions();
//		System.out.println(before);
//		assertTrue(0 < before);
	}

//          @Test
//        public void testExistById() {
//            int id = 10001;
//            assertTrue(questionClient.getQuestionById(id));
//        }

}