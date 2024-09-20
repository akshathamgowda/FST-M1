package examples;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class Newtest {
	//GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
  @Test
  public void getRequestWithQueryParam() {
	  //Send a request and save the response
	  Response response =
		given()
			.baseUri("https://petstore.swagger.io/v2/pet")
			.header("Content-Type","application/json")
			.queryParam("status","alive")
		.when()
			.get("/findByStatus");
	  
	  //Print the response headers
	  System.out.println(response.getHeaders());	  
	  //Print the response body
	  System.out.println(response.getBody().asPrettyString());
	  //Extract values from response
	  String petStatus = response.then().extract().path("[0].status");
	  System.out.println("Pet status is: " + petStatus);
	  
	  //TESTNG Assertions
	  Assert.assertEquals(petStatus, "alive");
	  //RestAssured assertions
	  response.then().statusCode(200).body("[0].status",equalTo("alive"));
  }
  
  @Test
  public void getRequestWithPathParam() {
	  given()
		.baseUri("https://petstore.swagger.io/v2/pet")
		.header("Content-Type","application/json")
		.pathParam("petId",77232)
		.log().all()
	  .when()
	  	.get("/{petId}")
	  	.then()
	  		.statusCode(200)
	  		.body("name", equalTo("Riley"))
	  		.body("status", equalTo("alive"))
	  		.log().all();
  }
}
