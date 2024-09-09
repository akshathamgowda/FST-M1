package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity9 {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.get("http://alchemy.hguy.co/crm");
      driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
      driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
      driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
      
      Thread.sleep(300);

      
      driver.findElement(By.xpath("//a[@id='grouptab_0']")).click(); // Click on Sales
      driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[5]//a[1]")).click(); // Click on Leads

      
      List<WebElement> names = driver.findElements(By.xpath("//th[@data-toggle='true']//a[@class='listViewThLinkS1']"));
      List<WebElement> users = driver.findElements(By.xpath("//th[8]//div[1]//a[1]"));

      System.out.println("First 10 Lead Names and Users:");
      for (int i = 0; i < Math.min(10, names.size()); i++) {
          System.out.println("Name: " + names.get(i).getText() + ", User: " + users.get(i).getText());
  }
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/crm");
  }
 

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
