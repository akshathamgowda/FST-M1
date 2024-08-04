package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		Actions action = new Actions(driver);
		
		driver.get("https://v1.training-support.net/selenium/drag-drop");
		System.out.println("Title of the page: " + driver.getTitle());
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement drop1 = driver.findElement(By.id("droppable"));
		WebElement drop2 = driver.findElement(By.id("dropzone2"));
		action.dragAndDrop(draggable, drop1).pause(20).build().perform();
		//verify if ball is dropped at zone 1
		String drop1Verify = drop1.findElement(By.tagName("P")).getText();
		if(drop1Verify == "dropped!")
		{
		    System.out.println("Ball is dropped at Zone1");	
	    }
		
		action.clickAndHold(drop1).moveToElement(drop2).pause(20).release().build().perform();
		String drop2Verify = drop2.findElement(By.tagName("P")).getText();
		if(drop2Verify == "dropped!") 
		{
			System.out.println("Ball is dropped at Zone2");
			
		}
		
		
		driver.quit();		
	}

}
