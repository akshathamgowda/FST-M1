package activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Acitivity7 {
	WebDriver driver;
  @Test(dataProvider="Credentials")
  
  public void loginTest(String username, String password, String exceptedMessage) {
	  WebElement usernameField= driver.findElement(By.id("username"));
	  WebElement passwordField= driver.findElement(By.id("password"));
	  WebElement loginbutton= driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button"));
	  
	  usernameField.clear();
	  passwordField.clear();
	  
	  usernameField.sendKeys(username);
	  passwordField.sendKeys(password);
	  
	  loginbutton.click();
	  
	 String message =driver.findElement(By.id("action-confirmation")).getText();
	 Assert.assertEquals(exceptedMessage, message);
	 
	 
	 
	  
	  
	  
	  
  }
  @BeforeClass
  public void setUp() {
	  
 WebDriverManager.firefoxdriver().setup();
 driver = new FirefoxDriver();
	  driver.get("https://v1.training-support.net/selenium/login-form");
	  
  }
  @DataProvider(name="Credentials")
  public static Object[][] creds(){
	  return new Object[][] {
		  {"admin","password","Welcome Back, admin"},
		  {"wrongadmin","wrongpassword","Invalid Credentials"}
	  };
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
