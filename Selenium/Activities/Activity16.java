package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity16 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
		//Get the title of the page and print it to the console.
		System.out.println("Print the tile of the page :" + driver.getTitle());
		
		//Find the input fields of the Sign Up form.
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[2]")).sendKeys("Akshatha");
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("Ibm112233");
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[3]")).sendKeys("Ibm112233");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sample@gmail.com");
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		
		//Wait for success message to appear and print it to the console.
		String message = driver.findElement(By.id("action-confirmation")).getText();
		Thread.sleep(1000);
		System.out.println("The message after registration: " +message);
		
		
		
		
		driver.quit();
	}

}
