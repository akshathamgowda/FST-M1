package activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.findElement(By.id("username")).sendKeys("username");
	  driver.findElement(By.id("password")).sendKeys("password");
	  driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
	  driver.findElement(By.id("action-confirmation")).getText();
	  Assert.assertEquals( "Welcome Back, admin", "loginmessage");
	  
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.firefoxdriver().setup();
	  driver.get("https://v1.training-support.net/selenium/login-form");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
