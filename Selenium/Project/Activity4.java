package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	WebDriver driver;
	
  @Test
  public void f() {
	  
	  driver.findElement(By.id("user_name")).sendKeys("admin");
	  driver.findElement(By.id("username_password")).sendKeys("​pa$$w0rd");
	  driver.findElement(By.id("bigbutton")).click();
	  
	  //driver.findElement(By.xpath("//*[@id=\"toolbar\"]/ul/li[1]/a")).isDisplayed();
	  Assert.assertEquals(driver.getTitle(), "SuiteCRM");
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
