package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity12 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		//Get the title of the page and print it to the console.
		System.out.println("Print the tile of the page :" + driver.getTitle());
		
		WebElement inputBox = driver.findElement(By.id("input-text"));
		System.out.println("Is Input field Enabled ? : " +inputBox.isEnabled());
		//Click the "Remove inputBox" button.
		driver.findElement(By.id("toggleInput")).click();
		Thread.sleep(1100);
		//Check if it is visible again and print the result.
		System.out.println("Is Input field Enabled ? : " +inputBox.isEnabled());
		
		driver.quit();
		


	}

}
