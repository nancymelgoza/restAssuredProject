package Trainning.RestAsssured;

import static org.apache.http.HttpStatus.*;
import static io.restassured.RestAssured.given;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResourceValidation {
	
	public ResourceValidation validacion(String resource)
	{
		try {
		 RequestSpecification request = given().when();
		 
		 Response response = request.get("/" + resource);
		 int status = response.getStatusCode();
//		 LOGGER.info(resource + " TEST the status code is: " + status);
		 System.out.println(resource + " TEST the status code is: " + status);
		 
		 response.then().assertThat().statusCode(SC_OK);
//		 response.then().assertThat().contentType(ContentType.JSON).and()
//         .body(matchesJsonSchemaInClasspath(""));
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
		 return this;
	}
	
}
