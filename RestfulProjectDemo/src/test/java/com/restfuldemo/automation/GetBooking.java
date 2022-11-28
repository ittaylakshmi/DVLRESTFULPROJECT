package com.restfuldemo.automation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetBooking {
	@Parameters({"url"})
	@Test
	public void getBooking(String url) {
		given()
			.log().all()
			.baseUri(url)
		.when()
		 	.get()
		.then()
			.log().all()
		;
		
	}

}
