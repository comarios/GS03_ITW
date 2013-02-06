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
 * This test is used to test resources in the AppResource.java
 * Resources to be tested
 * 1) storeApp
 * 2) getAppDetails
 *  
 * @author MConstantinides
 *
 */

@Category(IntegrationTest.class)
public class AppResourceTest {
	
		// Change that line to point to your File System
		private static final String pathToFile = "C:\\Users\\MConstantinides\\git\\GS03_ITW\\Group4.zip";
		private static final String resourceUpload = "aad-ws/api/application/upload";
		private static final String resourceAppDetails = "aad-ws/api/application/";
		private static final String appID = "1";
		
		static{
			RestAssured.port = 9999;
			
		}
		
		@Test
		public void testStoreApp() {
			System.out.println("*********************** Integration test ***********************");
			given().
				multiPart(new File(pathToFile)).
				parameters("name", "Group4 Testing", "description", "This is Group4 testing", "type", "1", "category", "1", "size", "500 KB").
			expect().
				statusCode(201).
			when().
				post(resourceUpload);
		}
		
		
		@Test
		public void testGetApplicationDetails() {
			given().
				contentType("application/json; charset=UTF-16");
			expect().
				statusCode(200).
			when().
				get(resourceAppDetails + appID);
		}
}
