package com.aad.ws.resource;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.parsing.Parser;
import com.aad.ws.resource.IntegrationTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 


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
	
	
	// Change that line to point to your File System
	private static final String pathToFile = "C:\\Users\\MConstantinides\\git\\GS03_ITW\\TestData\\submitResults\\result.json";
	
	private static final String resource = "aad-ws/api/results/submit/";
	private JSONParser parser = new JSONParser();
	
	static{
		RestAssured.port = 9999;
		
	}
	
	@Test
	public void testSubmitResult() {
		
		System.out.println("*********************** Testing SubmitResults  ********************************");
		
		Object obj;
		try {
			obj = parser.parse(new FileReader(pathToFile));
			
			JSONObject resultsJSON = (JSONObject) obj;
			
			given().
				parameters(resultsJSON).
				contentType("application/json; charset=UTF-16").
			expect().
				statusCode(201).
			when().
				post(resource);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
		
	}

}
