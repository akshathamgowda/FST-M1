package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/javascript-alerts");
		System.out.println("Title of the page: " + driver.getTitle());
		
		driver.findElement(By.id("confirm")).click();
		
		//Switch the focus from the main window to the Alert box and get the text in it and print it.
		String alertText  =driver.switchTo().alert().getText();
		System.out.println("Alert message: " +alertText);
		
		//Close the alert once with Ok and again with Cancel.
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirm")).click();
		driver.switchTo().alert().dismiss();
		
		//close browser
		driver.quit();

		
		

	}

}
