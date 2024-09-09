package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	WebDriver driver;
  @Test
  public void f() {
	  
	 String  headerimage = driver.findElement(By.xpath("//*[@id=\"form\"]/div[1]/img")).getAttribute("src");
	 System.out.println(headerimage);
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
