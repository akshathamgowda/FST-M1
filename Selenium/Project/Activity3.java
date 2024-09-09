package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	WebDriver driver;
  @Test
  public void f() {
	  
	  String footer = driver.findElement(By.id("admin_options")).getText();
	  System.out.println(footer);
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/crm");
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
