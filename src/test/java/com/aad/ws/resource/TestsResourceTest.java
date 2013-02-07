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
 * This test is used to test resources in the TestsResource.java
 * Resources to be tested
 * 1) getTests
 *  
 * @author MConstantinides
 *
 */

@Category(IntegrationTest.class)
public class TestsResourceTest {
	
	private static final String resource = "aad-ws/api/tests/";
	private static final String appID = "1";
	
	
	static{
		RestAssured.port = 9999;
		
	}
	
	@Test
	public void testGetTests() {
		System.out.println("*********************** Testing GetTests ***************************");
		given().
			contentType("application/json; charset=UTF-16");
		expect().
			statusCode(200).
		when().
			get(resource + appID);
	}

}
