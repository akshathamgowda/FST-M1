package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/javascript-alerts");
		System.out.println("Title of the page: " + driver.getTitle());
		//Find the button to open a PROMPT alert and click it.
		driver.findElement(By.id("prompt")).click();
		//Switch the focus from the main window to the Alert box and get the text in it and print it.
		String alertText = driver.switchTo().alert().getText();
		System.out.println("Alert message: " +alertText);
		Thread.sleep(2000);
		
		//Type Awesome into the prompt
		driver.switchTo().alert().sendKeys("Awesome !");
		Thread.sleep(2000);
		//Close the alert by clicking Ok.
		driver.switchTo().alert().accept();
		
		driver.quit();
		


	}

}
