package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/input-events");
		System.out.println("Title of the page: " + driver.getTitle());
		Actions action= new Actions(driver);
		
		
		//Left click and print the value of the side in the front
		action.click().pause(14000).build().perform();
		String frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Perform left click
        action.doubleClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Perform left click
        action.contextClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Close the browser
        driver.quit();
    }

		
		
		
		

	}


