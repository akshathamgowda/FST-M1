package activities;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;

public class Activity3 {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	//https://petstore.swagger.io/v2/pet
 
  @BeforeClass
  public void setUp() {
	  
	        requestSpec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet")
			  .addHeader("Content-Type", "application/json").build();
	  
	  //response builder
	  responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
			  .expectResponseTime(lessThanOrEqualTo(3000L)).build();
		  
  }
  
  @DataProvider
   public Object[][] dataProvid()
   {
	  Object[][] testData = new Object[][] {
		  { 77232, "Cherry", "alive" }, 
          { 77233, "Cookie", "alive" }
	  };
	  return testData;
   }
  
  @Test(priority=1)
  public void postMethod() {
	  String reqBody =  "{\"id\": 77232, \"name\": \"Cherry\", \"status\": \"alive\"}";
	  
	  Response response = given().spec(requestSpec)
			                 .body(reqBody)
			                .when().post();
	  //assertion
	  //response.then().log().all();
	 	  response.then().statusCode(200);
	 	  reqBody =  "{\"id\": 77233, \"name\": \"Cookie\", \"status\": \"alive\"}";
		  
		   response = given().spec(requestSpec)
				                 .body(reqBody)
				                .when().post();
		   
		//assetion
//		   response.then().log().all();
		   response.then().statusCode(200);
	    }
  
  @Test(dataProvider="dataProvid",priority=2)
  public void getMethod(int id, String name, String status) {
	  Response response = given().spec(requestSpec)
			         .when().pathParam("petId", id)
			         .get("/{petId}");
	  //Assertion
	  response.then().log().all();
	  response.then().body("name", equalTo(name));
  }
  
  @Test(dataProvider="dataProvid",priority=3)
  public void deleteMethod(int id, String name, String status)
  {
	  Response response = given().spec(requestSpec)
			               .when().pathParam("petId", id)
			               .delete("/{petId}");
	  //Assertion
	  response.then().statusCode(200);
  }

}
