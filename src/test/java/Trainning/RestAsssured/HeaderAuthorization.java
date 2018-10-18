package Trainning.RestAsssured;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeaderAuthorization extends BaseTest{

	HeaderValidationclass hvc = new HeaderValidationclass();
	
	public HeaderAuthorization(String url) {
		super("https://gp_search.grey.com/gp_searchapi");
	}
	
//	@Test
    public void validateResponseHeaders() {
        
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        // Create new JSON Object
        JsonObject loginCredentials = new JsonObject();
        loginCredentials.addProperty("", "");
        loginCredentials.addProperty("", "");
        httpRequest.body(loginCredentials.toString());
        Response response = httpRequest.post("/");
        String authorizationHeader = response.getHeader("Authorization");
//        String userIdHeader = response.getHeader("UserId");
        Assert.assertNotNull(authorizationHeader);
//        Assert.assertNotNull(userIdHeader);
    }
	  @Test
	    public void givenUrlBody() {
	      
//		  givenUrlBodyParam("qa", "publish_6847", "");
//		  hvc.givenUrlBodyParam("qa", "publish_6847", "");
		  hvc.givenUrlBodyParam("qa", "publish_6847");
		  
	    }

}
