package activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	WebDriver driver;
  @Test
  public void firstTest() {
	  
	  
	  Assert.assertEquals(driver.getTitle(), "Target Practice");
	  System.out.println("Title of page is" + driver.getTitle());
  }
	
	  @Test
	  public void secondTest() {
		  
		  WebElement blackbutton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
		  Assert.assertTrue(blackbutton.isDisplayed());
		  
		  
	  }

	  @Test(enabled = false)
	  public void thirdTest() {
		  
		  WebElement bluebutton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/button[2]"));
		  Assert.assertTrue(bluebutton.isDisplayed());
		  
		  
	  }
	  @Test()
	  public void fourthTest() {
		   
		  throw new SkipException("Skipping this test case");
		 
		  
		  
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
