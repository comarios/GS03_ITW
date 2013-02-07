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
 * This test is used to test resources in the AppsResource.java
 * Resources to be tested
 * 1) getAppsForCategory
 * 
 * @author MConstantinides
 *
 */

@Category(IntegrationTest.class)
public class AppsResourceTest {

	private static final String resource = "aad-ws/api/applications/";
	private static final String categoryID = "1";
	
	static{
		RestAssured.port = 9999;
	}
	
	@Test
	public void testGetAppsForCategory() {
		given().
			contentType("application/json; charset=UTF-16");
		expect().
			statusCode(200).
		when().
			get(resource + categoryID);
	}
}
