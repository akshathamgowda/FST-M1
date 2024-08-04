package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		//Get the title of the page and print it to the console.
		System.out.println("Print the tile of the page :" + driver.getTitle());
		//Find the checkbox input element.
		//Check if it is visible on the page.
		WebElement checkBox = driver.findElement(By.className("willDisappear"));
		System.out.println("Is checkbox visible : " + checkBox.isDisplayed());
		
		Thread.sleep(2000);
		
		//Click the "Remove Checkbox" button.
		driver.findElement(By.id("toggleCheckbox")).click();
		System.out.println("Is checkbox visible : " + checkBox.isDisplayed());
		
		
		
		driver.quit();
		
	}

}
