package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
	 WebDriver driver;
  @Test(priority=1)
  public void homePageTest() {
	  
	  Assert.assertEquals(driver.getTitle(), "Training Support");	
	  driver.findElement(By.id("about-link")).click();
  }
  @Test(priority=2)
  public void aboutPageTest() {
	  
	  Assert.assertEquals(driver.getTitle(), "About Training Support");	 
	  
  }
  @BeforeClass
  public void setUp() {
	  
	 
	  WebDriverManager.firefoxdriver().setup();
	  
	   driver.get("https://v1.training-support.net");
	  
  }

  @AfterClass
  public void teardown() {
	  
	  driver.quit();
  }

}
