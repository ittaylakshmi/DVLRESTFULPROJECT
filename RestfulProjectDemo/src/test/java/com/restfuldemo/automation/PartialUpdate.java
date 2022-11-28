package com.restfuldemo.automation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PartialUpdate {
	
	String partialRequest = "{\r\n"
			+ "    \"firstname\" : \"James\",\r\n"
			+ "    \"lastname\" : \"Brown\"\r\n"
			+ "}";
	@Parameters({"url"})
	@Test
	public void partialUpdate(String url) {
		given()
			.log().all()
			.baseUri(url + CreateBooking.bookingid)
			.header("Content-Type","application/json")
			.header("Accept","application/json")
			.header("Cookie","token="+CreateToken.token+"")
			.body(partialRequest)
		.when()
			.patch()
		.then()
			.log().all()
		;
		
		
		
	}
}
