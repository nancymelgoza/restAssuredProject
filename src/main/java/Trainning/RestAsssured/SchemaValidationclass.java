package Trainning.RestAsssured;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SchemaValidationclass {

	public SchemaValidationclass schemaValidation(String resource, String schema) {
		try {
		given().when().get(resource).then().assertThat()
				.body(matchesJsonSchemaInClasspath(schema));
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
		return this;
	}

	public SchemaValidationclass validateNodos(String id, String nameTest, Integer userId, String title, String msg) {
		try
		{
//		String json = given().pathParam("id", id).when().get("/posts/{id}").body().asString();	
		RequestSpecification request = given().pathParam("id", id);
		Response response = request.when().get("/posts/{id}");
		System.out.println(nameTest + " TEST ");
//		response.then().log().body();
//		JSONArray json = new JSONArray(response.asString());
//		String userId = json.get(0).toString();

		response.then().log().body().assertThat().body("userId", equalTo(userId)).and().body("id",equalTo(Integer.parseInt(id))).and().body("title", equalTo(title)).and().body("body", equalTo(msg));	
		
//		System.out.println(json);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
		return this;
	}
	
	public SchemaValidationclass getJsonVal(String resource, String name, String val) {
		try
		{
		String json = given().pathParam("resource", resource).pathParam("name", name).pathParam("val", val).when().get("/{resource}?{name}={val}").body().asString();	

		System.out.println("the " + resource + " body is: " +json);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
		return this;
	}
	
}
