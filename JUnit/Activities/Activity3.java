package Activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	 WebDriver driver;
  @Test
  public void loginiputTest() {
	  driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("password");
	  driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
	  String response=driver.findElement(By.id("action-confirmation")).getText();
	  Assert.assertEquals(response, "Welcome Back, admin");
  }
  @BeforeClass
  public void opeapp() {
	  WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(" https://v1.training-support.net/selenium/login-form");
  }
  

  @AfterClass
  public void logout() {
	  driver.close();
  }

}
