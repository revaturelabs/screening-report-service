package com.revature.screenforce.client;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.revature.screenforce.beans.Question;

import feign.RequestLine;

import org.junit.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class QuestionClientRestAssuredTesting {
	@Test
	public void testGetQuestions() {
		RestAssured.defaultParser = Parser.JSON;
		Response response = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
			   .when().get("http://localhost:8185/question").then().contentType(ContentType.JSON).extract().response(); 
		List<Integer> questionId = response.jsonPath().getList("questionId");
		assertTrue(questionId.size() == 22);
	}
//	@Test
//	public void testPostQuestion() {
//	   post("/question").then().statusCode(200).assertThat()
//	      .body("data.leagueId", equalTo(35)); 
//	}
}
