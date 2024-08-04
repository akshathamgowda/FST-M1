package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     WebDriverManager.firefoxdriver().setup();
		
		//initialize browser		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/login-form");
		System.out.println("Title of the page: " + driver.getTitle());
		//finding id of login and enter data
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		//finding id of pasword and enter data
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		//find element and click on login
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		//Print welcome text
		String messagetext =driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
		
		System.out.println("The message : " + messagetext);
	    
		driver.quit();

	}

}
