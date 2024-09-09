package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  
//	  driver.findElement(By.id("user_name")).sendKeys("admin");
//	  driver.findElement(By.id("username_password")).sendKeys("​pa$$w0rd");
//	  driver.findElement(By.id("bigbutton")).click();
	  
	  driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
	  driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
	  
	  Thread.sleep(40);
	  String color = driver.findElement(By.xpath("//div[@id='toolbar']")).getCssValue("color");
	  System.out.println(color);
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.firefoxdriver().clearDriverCache();
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/crm");
  }

  @AfterClass
  public void afterClass() {
	  
	  
	  driver.quit();
  }

}
