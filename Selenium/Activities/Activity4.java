package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/target-practice");
		//Get the title of the page and print it to the console.
		System.out.println("Title of the page: " + driver.getTitle());
		//Using xpath:
		//Find the 3rd header on the page and print it's text to the console.
		String header3 = driver.findElement(By.tagName("h3")).getText();
		System.out.println("Third header of the page: " + header3);
		
		//Find the 5th header on the page and print it's color
		String color = driver.findElement(By.tagName("h5")).getCssValue("color");
		System.out.println("Color of the 5th header: " + color);
		
		//Using any other locator:
		//Find the violet button and print all it's classes.
		String colorClass = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
		System.out.println("Class of the violet color: " +colorClass);
		
		//Find the grey button and print it's text.
		String colortext = driver.findElement(By.xpath("//button[text()='Grey']")).getText();
		System.out.println("Color fo the text: " +colortext);
		
		driver.quit();		
		
		
		
		

	}

}
