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

@Test
public class Activity8 {
	WebDriver driver;
  public void fTest() throws Exception {
	  
	  driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
	  driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
	  
	  Thread.sleep(20);
	  WebElement sales = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
	  sales.click();
	Thread.sleep(5000);
	 driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[2]//a[1]")).click();//accounts
	 Thread.sleep(5000);
	 WebElement table = driver.findElement(By.id("accountsTable"));
	 List<WebElement> rows = table.findElements(By.tagName("tr"));

	 
	 int count = 0;
     for (int i = 1; i < 10; i += 2) {  // Start at index 1 and increment by 2 to get odd-numbered rows
         if (count >= 5) {
             break;
         }
         List<WebElement> cells =driver.findElements(By.tagName("td"));
         if (!cells.isEmpty()) {
             System.out.println(cells.get(0).getText());  // Assuming the name is in the first cell
             count++;
         }
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
	 // driver.quit();
  }

}
