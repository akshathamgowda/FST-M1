package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		
		//initialize broweser
		WebDriver driver = new FirefoxDriver();
		
		//open browser
		driver.get("https://v1.training-support.net/");
		
		System.out.println("Home page title :" + driver.getTitle());
	//	Thread.sleep(200);
		
		driver.findElement(By.id("about-link")).click();
		
		System.out.println("Home page title : " + driver.getTitle());
		
		driver.quit();
		

	}

}
