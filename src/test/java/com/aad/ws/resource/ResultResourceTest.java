package com.aad.ws.resource;

import static com.jayway.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.jayway.restassured.RestAssured;

/***
 * This test is used to test resources in the ResultResource.java Resources to
 * be tested 1) submitResults
 * 
 * @author MConstantinides
 * 
 */

@Category(IntegrationTest.class)
public class ResultResourceTest {

	// Change that line to point to your File System
	private static final String pathToFile = "C:\\Users\\MConstantinides\\git\\GS03_ITW\\TestData\\submitResults\\result.json";

	private static final String resource = "aad-ws/api/result/submit/";

	static {
		RestAssured.port = 9999;

	}

	@Test
	public void testSubmitResult() {

		System.out
				.println("*********************** Testing SubmitResults  ********************************");

		try {
			
			BufferedReader br = new BufferedReader(new FileReader(pathToFile));
			String buffer;
			StringBuilder rawJson = new StringBuilder();
			while((buffer = br.readLine()) != null)
			{
				rawJson.append(buffer);
			}

			given().
				contentType("application/json; charset=UTF-16").
				body(rawJson.toString()).
			expect().
				statusCode(201).
			when().
				post(resource);
		
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
