package com.api.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimplePostTest {

	
	@Test
	public void registerCustomer() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Vishal"); 
		requestParams.put("LastName", "Gupta");
		 
		requestParams.put("UserName", "simpleuser36482");
		requestParams.put("Password", "password1_23");
		requestParams.put("Email",  "someuser4393@gmail.com");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		 
		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		 
		// Post the request and check the response
		Response response = request.post("/register");
		
		int statusCode = response.getStatusCode();
		System.out.println("statuscode: "+statusCode);
		System.out.println("Response body: " + response.body().asString());
		/*Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");*/
	}
}
