package Trainning.RestAsssured;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import java.util.logging.Logger;

import static org.apache.http.HttpStatus.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.*;

public class SimpleRestAssured extends BaseTest{
	
	private static final Logger LOGGER = Logger.getLogger(SimpleRestAssured.class.getName());
	ResourceValidation rv = new ResourceValidation();

	public SimpleRestAssured(String url) {
		super("https://jsonplaceholder.typicode.com");
	}
//	@DataProvider(name = "resources")
//	public Object[][] statusValidation() {
//		return new Object[][] { 
//				{ "/posts" },
//				{"/comments"},		
//				{ "/albums" },
//				{"/photos"},
//				{ "/users" },
//				{"/todos"}	};
//	}

//	@Test(dataProvider = "resources")
	@Test(testName = "posts")
	public void getPosts() {
		 rv.validacion("posts");

	}
	
	@Test(testName = "comments")
	public void getComments() {
		 rv.validacion("comments");

	}
	
	@Test(testName = "albums")
	public void getAlbums() {
		 rv.validacion("albums");

	}
	
	@Test(testName = "photos")
	public void getPhotos() {
		 rv.validacion("photos");

	}
	
	@Test(testName = "users")
	public void getUsers() {
		 rv.validacion("users");
	}
	
	@Test(testName = "todos")
	public void getTodos() {
		rv.validacion("todos");

	}
	
	
}
