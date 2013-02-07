package com.aad.ws.resource;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.jayway.restassured.RestAssured;
import com.aad.ws.resource.IntegrationTest;


/***
 * This test is used to test resources in the ResultResource.java
 * Resources to be tested
 * 1) submitResults
 *
 * @author MConstantinides
 *
 */

@Category(IntegrationTest.class)
public class ResultResourceTest {
	
	private static final String resource = "aad-ws/api/results/submit/";
	
	static{
		RestAssured.port = 9999;
		
	}
	
	@Test
	public void testSubmitResult() {
		System.out.println("*********************** Integration test ***********************");
		given().
			parameters("name", "Group4 Testing", "description", "This is Group4 testing", "type", "1", "category", "1", "size", "500 KB", "developer", "Group4 Dev Team").
		expect().
			statusCode(201).
		when().
			post(resource);
	}

}
