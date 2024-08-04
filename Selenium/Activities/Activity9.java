package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://v1.training-support.net/selenium/ajax");
		//Get the title of the page and print it to the console.
		System.out.println("Print the tile of the page :" + driver.getTitle());
		//Find and click the "Change content" button on the page
		driver.findElement(By.xpath("//button[text()='Change Content']")).click();
		//Wait for the text to say "HELLO!". Print the message that appears on the page.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		String text = driver.findElement(By.tagName("h1")).getText();
		System.out.println("The header texta appears is: " + text);
		
		//Wait for the text to change to contain "I'm late!". Print the new message on the page.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));
		String latetext = driver.findElement(By.tagName("h3")).getText();
		System.out.println("The subheader is : " + latetext);
		
		driver.quit();
		
		
				
		
	}

}
