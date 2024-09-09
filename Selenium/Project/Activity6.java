package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity6 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
	  driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
	  
	  Thread.sleep(100);
	  WebElement Activities = driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]"));
	  System.out.println("Activities");
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
