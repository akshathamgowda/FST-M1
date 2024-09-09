package Liveproject;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
public class projectActivity {
	 RequestSpecification requestSpec;
	  String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAILYnWdhuUYVaTOzDxLeTJaql/4rXUpAaJKWbT4iUTEbZ";
	  int sshKeyid;
	 
  @BeforeClass
  public void setUp() {
	  requestSpec = new RequestSpecBuilder()
			        .setBaseUri("https://api.github.com/user/keys")
			        .addHeader("Content-Type", "application/json")
			        .addHeader("Authorization", "token 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")
			        .build();
  }
  @Test(priority=1)
  public void addSSHKey() {
		Map<String, String> reqBody = new HashMap<String, String>();
		// create request body
		reqBody.put("title", "TestAPIKey");
		reqBody.put("key", sshKey);
	 
	  Response response = given().spec(requestSpec).body(reqBody)
			              .when()
			              .post();
	 
	  response.prettyPrint();
    response.then().log().all();
    //extract id
	sshKeyid = response.then().extract().path("id");
	System.out.println("sshKeyid: " +sshKeyid);
	response.then().statusCode(201);
		
  }
  @Test(priority=2)
  public void getSSHKey() {
	 
	  Response response = given().spec(requestSpec)
			                 .pathParam("keyId", sshKeyid)
			                 .when().get("/{keyId}");
	 
	  Reporter.log(response.asPrettyString());
	  //Assertion
	  response.then().statusCode(200);
	 
  }
  @Test(priority=3)
  public void deleteSSHKey() {
	  Response response = given().spec(requestSpec)
			               .pathParam("keyId", sshKeyid)
			               .when().delete("/{keyId}");
	 
	  Reporter.log(response.asPrettyString());
	  //Assertion
	  response.then().statusCode(204);
  }
}
