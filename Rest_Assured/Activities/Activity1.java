package activities;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
  @Test(priority=1)
  public void storeData() {
	  Response response = 
			  given()
			     
			      .header("Content-Type", "application/json")
			      .body("{\n"
			      		+ "	\"id\" : 772001,\n"
			      		+ "	\"name\" : \"Cherry\",\n"
			      		+ "	\"status\" : \"alive\"\n"
			      		+ "	\n"
			      		+ "}")
			   .when()
			       .post("https://petstore.swagger.io/v2/pet");
	  
//	  response.then().statusCode(200);
	  
	  String data = response.getBody().asPrettyString();
	  System.out.println("Printing the body of post request " +data);
	  System.out.println("Status code" + response.then().log().status());
   
	    }
  
  @Test(priority=2)
  public void getMethod() {
	  
	  Response response = 
			     given()
			     .header("Content-Type","application/json")
			     .when().pathParam("petId", "772001")
			     .get("https://petstore.swagger.io/v2/pet/{petId}");
	  
	  //Assertion
	  response.then().statusCode(200);
	 // response.then().body("petId", equalTo(772001));
	  response.then().body("status", equalTo("alive"));
	  response.then().body("name",equalTo("Cherry"));			     
	
  }
  
  @Test(priority=3)
  public void deleteRequest() {
	  Response response = 
			     given()
			       .header("Content-Type","application/json")
			       .when().pathParam("petId","772001")
			       .delete("https://petstore.swagger.io/v2/pet/{petId}");
	  
	  //Assertion
	  
	  response.then().statusCode(200);
	  response.then().body("code", equalTo(200));
	  response.then().body("message", equalTo("772001"));
	  response.then().log().all();
  }
}
