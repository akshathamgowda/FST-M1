package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		
		driver.get("https://v1.training-support.net/selenium/popups");
		//Get the title of the page and print it to the console.
		System.out.println("Print the tile of the page :" + driver.getTitle());
		
		WebElement name = driver.findElement(By.className("orange"));
       //Find the Sign in button and hover over it. Print the tooltip message.
		a.moveToElement(name).build().perform();
	
		System.out.println("The Mouse over text : " + name.getAttribute("data-tooltip"));
		//Click the button to open the Sign in form
		name.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
	

        // Find the input fields
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        // Enter the credentials
        username.sendKeys("admin");
        password.sendKeys("password");
        // Click the login button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        // Print the login message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);

        // Close the browser
        driver.quit();

		
	}

}
