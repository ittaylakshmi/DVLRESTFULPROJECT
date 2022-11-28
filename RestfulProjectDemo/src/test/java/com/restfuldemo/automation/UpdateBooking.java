package com.restfuldemo.automation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UpdateBooking {
	@Parameters({"url"})
	@Test
	public void updateBooking(String url) {
		
		String requestBody =  "{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		given()
			.log().all()
			.baseUri(url + CreateBooking.bookingid)
			.header("Content-Type","application/json")
			.header("Accept","application/json")
			.header("Cookie","token="+CreateToken.token+"")
			.body(requestBody)
		.when()
			.put()
		.then()
			.log().all()
		;
		
	}

}
