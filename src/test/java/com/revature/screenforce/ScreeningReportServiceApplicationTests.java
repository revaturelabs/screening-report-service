package com.revature.screenforce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScreeningReportServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
    public void testGetReportWithEmail() {
        given()
            .port(port)
            .when()
            .get("/getReportWithEmail?startDate={startDate}8&endDate={endDate}&email={email}", "03/01/2018", "03/02/2018", "gadams@mailinator.com")
            .then()
            .statusCode(200);
    }
    
    @Test
    public void testGetAllEmail() {
        given()
            .port(port)
            .when()
            .get("/getEmails?email={email}", "gadams@mailinator.com")
            .then()
            .statusCode(200);
    
    }
}
