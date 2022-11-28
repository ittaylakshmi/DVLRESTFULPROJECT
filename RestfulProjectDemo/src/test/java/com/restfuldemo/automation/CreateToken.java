package com.restfuldemo.automation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class CreateToken {
	
	public static String token;
	@Test
	public void createToken() {
		
		String tokenBody = "{  \r\n"
				+ "  \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		token = given()
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com/auth")
			.header("Content-Type","application/json")
			.body(tokenBody)
		.when()
			.post()
		.then()
			.log().all()
			.extract().jsonPath().getString("token");
			System.out.println(token);
		;
		
	}

}
