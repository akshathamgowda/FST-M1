package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;

public class Activity7 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {

	  
	  driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
	  driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
	  
	  Thread.sleep(20);
	  WebElement sales = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
	  sales.click();
	Thread.sleep(60);
	 // Actions actions = new Actions(driver);
	 // actions.moveToElement(sales);
	  
	 WebElement leads = driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[5]//a[1]"));
	 leads.click();
	  //actions.moveToElement(subMenu);
	  //actions.click().build().perform();  
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//span[@id='adspan_dff2dd29-8a3f-22b6-bd24-5f5a7d339e97']//span[@title='Additional Details']")).click();
	  Thread.sleep(5000);
	  
	  
	//  WebElement additionalInfo = driver.findElement(By.xpath("//span[@id='adspan_dff2dd29-8a3f-22b6-bd24-5f5a7d339e97']//span[@title='Additional Details']"));
	 // actions.moveToElement(additionalInfo).click().build().perform();
	  //Thread.sleep(20);
	 String phonenumber = driver.findElement(By.xpath("//span[@class='phone']")).getText();
	 System.out.println(phonenumber);
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
	  //driver.quit();
  }

}
