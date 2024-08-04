package activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.getTitle();
	  System.out.println("Title of page is" + driver.getTitle());
	  Assert.assertEquals(title , Target Practice);
  }
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
	  
	  driver.get("https://v1.training-support.net/selenium/target-practice");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
