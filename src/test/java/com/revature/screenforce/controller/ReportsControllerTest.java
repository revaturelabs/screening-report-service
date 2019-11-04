package com.revature.screenforce.controller;

import static org.hamcrest.Matchers.hasItems;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportsControllerTest {


		@Test
		public void testSingleFRM() {
			 given().
			    when().
			        get("http://localhost:8185/frmtest/").
			    then().
			        assertThat().
			        statusCode(200).
			    and().
			    	assertThat().
			    	body("screener_id", equalTo(3)).
			    and().
			    	assertThat().
			    	body("srm.screeningId",equalTo(4321));
		}
		@Test
		public void testFRMById() {
			 given().
			    when().
			        get("http://localhost:8185/frm/4323").
			    then().
			        assertThat().
			        statusCode(200).
			    and().
			    	assertThat().
			    	body("screener_id", equalTo(4)).
			    and().
			    	assertThat().
			    	body("srm.screeningId",equalTo(4323));
		}
		@Test
		public void testSRMDates() {
			 given().
			    when().
			        get("http://localhost:8185/srm/2018-03-05/2018-03-09").
			    then().
			        assertThat().
			        statusCode(200).
			    and().
			    	assertThat().
			    	body("screeningId", hasItems(4323, 4325)).
			    and().
			    	assertThat().
			    	body("track.trackId",hasItems(51, 52));
			 }

}
