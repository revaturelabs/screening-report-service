package com.revature.screenforce;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.beans.Question;
import com.revature.screenforce.controllers.QuestionController;
import com.revature.screenforce.services.QuestionService;

import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScreeningReportServiceApplicationTests {

	@Autowired
	QuestionService service;

		
		@Test
		public void exampleJUnitTest() {
//		assertEquals(2, mathUtils.add(1, 1), 
//			"Add method should return the sum of two numbers");			}
        }
		
		
		@Test
		public void exampleRestTest() {
//		    given()
//		        .contentType(ContentType.JSON)
//		        .pathParam("id", "AskJsd8Sd")
//		    .when()
//		        .get("/examplepath/{id}")
//		    .then()
//		        .statusCode(200)
//		        .body("firstName", equalTo("Onur"))
//		        .body("Surname", equalTo("Baskirt"));
		}
		
		@Test
		public void getQuestionTest()
		{
			QuestionController qc = new QuestionController();
			Question[] q = qc.getQuestions();
			assertTrue(q.length > 0);
		}

}

