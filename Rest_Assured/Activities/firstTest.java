package examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class firstTest {
	//GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
  @Test
  public void getRequestWithQueryParam() {
	  //send a request and save the response
	  Response response =
			 given()
			     .baseUri("https://petstore.swagger.io/v2/pet")
			     .header("Content-Type","application/json")
			     .queryParam("status", "alive")
			  .when()
			      .get("/findByStatus");
	  
	  //print the headers
	  System.out.print(response.getHeaders());
	  
	  //print the response body
	  System.out.println(response.getBody().asPrettyString());
	  
	  // extract values from response
	  String petStatus = response.then().extract().path("[0].status");
	  System.out.println("Pet Status is: " +petStatus);
	  
	  //TestNG Assertions
	  Assert.assertEquals(petStatus, "alive");
	  
	  //RestAssured Assertions
	  response.then().statusCode(200).body("[0].status", equalTo("alive"));
	  
	
	  
			     
  }
  
  //GET https://petstore.swagger.io/v2/pet/{petId}
  @Test
  public void getRequestWithPathParam() {
	  //send a request, get the response and assert with logging
	  given()
	      .baseUri("https://petstore.swagger.io/v2/pet")
	      .header("Content-Type","application/json")
	      .pathParam("petId",77232)
	      .log().all()
	   .when()
	      .get("/{petId}")
	    .then()
	       .statusCode(200)
	       .body("name", equalTo("Cherry"))
	       .body("status", equalTo("alive"))
	       .log().all();
  }
}
