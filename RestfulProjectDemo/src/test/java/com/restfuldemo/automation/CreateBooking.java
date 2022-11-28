package com.restfuldemo.automation;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.restfuldemo.automation.dataprovider.GetTestData;
import io.restassured.path.json.JsonPath;

public class CreateBooking {
	//this Class will createbooking ID
	String response;
	static int bookingid;
	
	@Test (dataProvider="testdata")
	public void createBooking(String firstName, String lastName, String totalPrice, String depositPaid, String checkIn, String checkOut, String additionalNeeds) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("firstname", firstName);
		map.put("lastname", lastName);
		map.put("totalprice", Integer.parseInt(totalPrice));
		map.put("depositpaid", Boolean.parseBoolean(depositPaid));
		Map<String, String>	map1=new HashMap<String, String>();
		map.put("bookingdates", map1);
		map1.put("checkin", checkIn);
		map1.put("checkout", checkOut);
		map.put("additionalneeds", additionalNeeds);	
		
		response = given()
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com/booking")
			.header("Content-Type", "application/json")
			.body(map)
		.when()
			.post()
		.then()
			.log().all()
			.extract().response().asString();
			JsonPath js=new JsonPath(response);
			bookingid = js.getInt("bookingid");
			System.out.println(bookingid);
		;
		}
	
	
	@DataProvider(name = "testdata")
	public Object[][] testData() throws Exception {
		
		
	return GetTestData.getTestData("C:\\Users\\dimil\\OneDrive\\Desktop\\RestassuredTestdata\\TestData.xlsx", "Sheet1");
		
		 
		 
//		Object[][] data = {
//			{"jim","cat","111","true","2018-01-22","2019-01-22","Lunch"},
//			{"jim1","cat1","222","true","2018-01-22","2019-01-22","Lunch"}
	}
//		return data;
}

