package Trainning.RestAsssured;

import org.testng.Assert;
import io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeaderValidationclass {
	
	 String aut;
	 
	 public Response givenResponseBody() {
	        
	        Header authorizationHeader = new Header("Authorization", "");
	        RequestSpecification httpRequest = RestAssured.given();
	        httpRequest.header(authorizationHeader);
	        
	        Response response = httpRequest.get();	        
	        
	        return response;
	 }
	 
	 public HeaderValidationclass givenUrlBodyParam(String qa, String publish) { //String aut
	        try
	        {
	        Header authorizationHeader = new Header("Authorization", aut);
	        RequestSpecification httpRequest = RestAssured.given().pathParam("u", qa).pathParam("q", publish);
	        httpRequest.header(authorizationHeader);
	        Assert.assertNotNull(authorizationHeader);
	        Response response = httpRequest.get("search?u={u}&q={q}&d=id&p=t&c=t&s=publish&m=all");
	      
	        System.out.println("Response Body is : " + response.body().asString());
	        }
	        catch(Exception ex) {
	        	System.out.println(ex.getMessage().toString());
	        }
	        return this;
	        
	    }
}
