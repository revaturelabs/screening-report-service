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

public class QuestionClientRestAssuredTesting {
	/**
	 * Method to test retrieval of all questions
	 */
	@Test
	public void testGetQuestions() {
		RestAssured.defaultParser = Parser.JSON;
		Response response = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
			   .when().get("http://localhost:8185/question").then().contentType(ContentType.JSON).extract().response(); 
		List<Integer> questionId = response.jsonPath().getList("questionId");
		assertTrue(questionId.size() == 22);
		assertTrue(questionId.get(0) == 10001);
		assertTrue(questionId.get(21) == 10022);
	}
	/**
	 * Method to test adding a new question to the database
	 */
	@Test
	public void testPostQuestion() {
		RestAssured.baseURI = "http://localhost:8185";
        Response response = given().urlEncodingEnabled(true)
            .param("s", "Test Question")
            .header("Accept", ContentType.JSON.getAcceptHeader())
            .post("/question")
            .then().statusCode(200)
            .extract()
            .response();
        Integer questionId = Integer.parseInt(response.jsonPath().getString("questionId"));
        assertTrue(questionId > 0);
	}
}
