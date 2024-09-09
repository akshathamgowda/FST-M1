package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	
	WebDriver driver;
	
  @Test
  public void f() {
	  
	 Assert.assertEquals(driver.getTitle(), "SuiteCRM");
  }
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.firefoxdriver().setup();
	  driver  = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/crm");
  }

  
@AfterClass
  public void afterClass() {
	
	driver.quit();
  }

}
