package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		
		WebElement dyanmicCheckbox = driver.findElement(By.id("dynamicCheckbox"));
		
		driver.findElement(By.id("toggleCheckbox")).click();
		wait.until(ExpectedConditions.invisibilityOf(dyanmicCheckbox));
		 System.out.println("Element is available : " +dyanmicCheckbox.isDisplayed());
	
		 //Click the button again. Wait till it appears and check the checkbox.
			
			driver.findElement(By.id("toggleCheckbox")).click();
			wait.until(ExpectedConditions.visibilityOf(dyanmicCheckbox));
			 System.out.println("Element is available :" +dyanmicCheckbox.isDisplayed());
			 
			 driver.quit();

	}

	
}
