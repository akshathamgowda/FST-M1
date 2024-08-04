package examples;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

public class SpecificationTest {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId;

	@BeforeClass
	public void setUp() {
		//request specification
		requestSpec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet")
				.addHeader("Content-Type", "application/json").build();

		// REsponse specification

		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectResponseTime(lessThanOrEqualTo(3000L))
				.build();
	}

	@Test(priority = 1)
	public void postRequest() {
		// create Request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		// create request body
		reqBody.put("id", 7322);
		reqBody.put("name", "Cherry");
		reqBody.put("status", "alive");

		// send request, save response
		Response response = given().spec(requestSpec).body(reqBody).when().post();
		// extract id from the response
		petId = response.then().extract().path("id");
		// Assertions
		response.then().spec(responseSpec).body("name", equalTo("Cherry")).body("status", equalTo("alive"));

	}

	// Get Request
	@Test(priority = 2)
	public void getRequest() {
		given().spec(requestSpec).pathParam("petId", petId).when().get("/{petId}").then().spec(responseSpec)
				.body("status", equalTo("alive"));
	}

	// Delete Request
	@Test(priority = 3)
	public void deleteRequest() {
		// send a request,
		given().spec(requestSpec).pathParam("petId", petId).when().delete("/{petId}").then().spec(responseSpec)
				.body("message", equalTo("" + petId));
	}

	

}
