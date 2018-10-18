package Trainning.RestAsssured;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	private String url;//= "https://jsonplaceholder.typicode.com";
	
	@BeforeClass
	public void response() {
		
		 baseURI = url;
	}
	
	public BaseTest(String url) {
//		super();
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public static final Integer STATUS_OK = 200;
	public static final Integer STATUS_BAD = 400;

}

