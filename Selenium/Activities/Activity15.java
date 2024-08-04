package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
		//Get the title of the page and print it to the console.
		System.out.println("Print the tile of the page :" + driver.getTitle());
		
		//Find the username and password input fields. Type in the credentials
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		//Wait for login message to appear and print the login message to the console.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
		
		WebElement message = driver.findElement(By.id("action-confirmation"));
		
		System.out.println("The message :" +message.getText());
		
		driver.quit();

	}

}
