package Trainning.RestAsssured;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath; 
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema; 

import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SchemaValidation extends BaseTest {
	
	SchemaValidationclass svc = new SchemaValidationclass();
	
	public SchemaValidation(String url) {
		super("https://jsonplaceholder.typicode.com");
	}

	@Test(testName = "postsSchemaValidation")
	public void postsSchemaValidation() {
		svc.schemaValidation("/posts", "postSchema.json");
//		schemaValidation("/posts", "postSchema.json");

	}

	@Test(testName = "commentsSchemaValidation")
	public void commentsSchemaValidation() {
		svc.schemaValidation("/comments", "commentsSchema.json");
//		schemaValidation("/comments", "commentsSchema.json");
	}

	@Test(testName = "albumsSchemaValidation")
	public void albumsSchemaValidation() {
		svc.schemaValidation("/albums", "albumsSchema.json");
//		schemaValidation("/albums", "albumsSchema.json");
	}

	@Test(testName = "usersSchemaValidation")
	public void usersSchemaValidation() {
		svc.schemaValidation("/users", "usersSchema.json");
//		schemaValidation("/users", "usersSchema.json");
	}

	@Test(testName = "todosSchemaValidation")
	public void todosSchemaValidation() {
		svc.schemaValidation("/todos", "todosSchema.json");
//		schemaValidation("/todos", "todosSchema.json");
	}

	@Test(testName = "postsId20")
	public void postsId20() {
		String msg ="qui consequuntur ducimus possimus quisquam amet similique"+"\n"+ "suscipit porro ipsam amet"+ "\n"+"eos veritatis officiis exercitationem vel fugit aut necessitatibus totam"+"\n"+ "omnis rerum consequatur expedita quidem cumque explicabo";
		svc.validateNodos("20", "postsId20", 2, "doloribus ad provident suscipit at", msg);
	}

	@Test(testName = "postsId50")
	public void postsId50() {
		String msg ="error suscipit maxime adipisci consequuntur recusandae"+"\n"+"voluptas eligendi et est et voluptates"+"\n"+ "quia distinctio ab amet quaerat molestiae et vitae"+"\n"+"adipisci impedit sequi nesciunt quis consectetur";
		svc.validateNodos("50", "postsId50", 5,"repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem",msg);
	}

	@Test
	public void postsId100() {
		String msg ="cupiditate quo est a modi nesciunt soluta"+"\n"+"ipsa voluptas error itaque dicta in"+"\n"+"autem qui minus magnam et distinctio eum"+"\n"+"accusamus ratione error aut";
		svc.validateNodos("100", "postsId100", 10, "at nam consequatur ea labore ea harum", msg);
	}
	
	@Test
	public void getCommentsPostId1() {
		svc.getJsonVal("comments", "postId", "1");
	}
	
	@Test
	public void getPostsUserId1() {
		svc.getJsonVal("posts", "userId", "1");
	}
}
