package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class activity2 {

	public static void main(String[] args) throws InterruptedException   {
	
		WebDriverManager.firefoxdriver().setup();
		
		//initialize browser		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/login-form");
		System.out.println("Title of the page: " + driver.getTitle());
		//finding id of login and enter data
		driver.findElement(By.id("username")).sendKeys("admin");
		//finding id of pasword and enter data
		driver.findElement(By.id("password")).sendKeys("password");
		//find element and click on login
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(300);
		
		driver.quit();
		
		
		
  
		
	}

}
