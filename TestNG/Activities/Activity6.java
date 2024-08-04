package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {
	WebDriver driver;
	  @BeforeClass
	  public void beforeClass() {
	    //Setup Edge driver
		  WebDriverManager.edgedriver().setup();
		//Initialize driver
		  driver = new EdgeDriver();
		  driver.manage().window().maximize();
		
	        
	    //Open browser
	      driver.get("https://v1.training-support.net/selenium/login-form");
	  }
	  @Test
	    @Parameters({"username", "password"})
	    public void loginTestCase(String username, String password) {
	        //Find username and pasword fields
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        
	        //Enter values
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        
	        //Click Log in
	        driver.findElement(By.cssSelector("button[type='submit']")).click();
	        
	        //Assert Message
	        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	        Assert.assertEquals(loginMessage, "Welcome Back, admin");
	        System.out.println("Activity6 ran sucessfully");
	    }
	 
	    @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
