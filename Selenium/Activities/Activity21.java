package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity21 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://v1.training-support.net/selenium/tab-opener");
		System.out.println("Title of the page: " + driver.getTitle());
		
		//Print window handle
		System.out.println("Parent window handle :" + driver.getWindowHandle());
       //Find the button to open a new tab and click it.
		driver.findElement(By.id("launcher")).click();
		//Wait for the new tab to open.
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Thread.sleep(1000);
		 
		for(String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);			
		}
		
		WebElement actionbutton = driver.findElement(By.id("actionButton"));
		
		wait.until(ExpectedConditions.visibilityOf(actionbutton));
		System.out.println("Current window handle : " + driver.getWindowHandle());
		System.out.println("Header of the title : " + driver.getTitle());
		
		String text = driver.findElement(By.className("content")).getText();
		//Printing the content of the page
		System.out.println("Content of the page: " +text);
		
		actionbutton.click();
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		Thread.sleep(1000);
		 
		for(String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);			
		}
		
		
		System.out.println("Current window handle : " + driver.getWindowHandle());
		System.out.println("Header of the title : " + driver.getTitle());
		
		text = driver.findElement(By.className("content")).getText();
		//Printing the content of the page
		System.out.println("Content of the page: " +text);

		
		
		
		driver.quit();

	}

}
