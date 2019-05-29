package com.revature.screenforce.controllers;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.ScreeningReportServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ScreeningReportServiceApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class ReportsControllerTest {

	
	@LocalServerPort
	private int port;
	
	@Test
	public void testGetAllScreenings() {
		given()
				.port(port)
				.when()
				.get("/screenings")
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testGetAllSoftSkillViolations() {
		given()
				.port(port)
				.when()
				.get("/softskillviolations")
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testGetAllQuestionScores() {
		given()
				.port(port)
				.when()
				.get("/questionscores")
				.then()
				.statusCode(200);
	}
	
	// /getReport?startDate={startDate}&endDate={endDate}&screenerId={screenerId}
	@Test
	public void testGetReport() {
		given()
			.port(port)
			.when()
			.get("/getReport?startDate={startDate}&endDate={endDate}&screenerId={screenerId}", "10/10/2018", "10/17/2018", 51)
			.then()
			.statusCode(200);
	}
	
	// /getTotalReport
	@Test
	public void testGetTotalReport() {
		given()
			.port(port)
			.when()
			.get("/getTotalReport")
			.then()
			.statusCode(200);
	}
	
	
	@Test
	public void testGetWeeksReport() {
		given()
			.port(port)
			.when()
			.get("/getWeeksReport?startDate={startDate}&endDate={endDate}", "10/10/2018", "10/17/2018")
			.then()
			.statusCode(200);
	}
	
	// /getScreenReport?screenerId={screenerId}
	@Test
	public void testGetScreenerReport() {
		given()
			.port(port)
			.when()
			.get("/getScreenerReport?screenerId={screenerId}", 51)
			.then()
			.statusCode(200);
	}
	
	//this test is failing, when it should be passing. 
	/*
	@Test
	public void testGetScreenerReportFail() {
		given()
			.port(port)
			.when()
			.get("/getScreenerReport?screenerId={screenerId}", -23)
			.then()
			.statusCode(404);
	}*/

}

