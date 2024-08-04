package activities;

import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://v1.training-support.net/selenium/selects");
		System.out.println("Title of the page: " + driver.getTitle());
		
		WebElement dropdown = driver.findElement(By.id("single-select"));
		
		Select s = new Select(dropdown);
		
		s.selectByVisibleText("Option 2");
		System.out.println("Second Option: " + s.getFirstSelectedOption().getText());
		s.selectByIndex(3);
		System.out.println("Third Option: " + s.getFirstSelectedOption().getText());
		s.selectByValue("4");
		System.out.println("Fourth Option: " + s.getFirstSelectedOption().getText());
		
		List<WebElement> options = s.getOptions();
		System.out.println("All the options of the dropdown ");
		for (WebElement option : options)
		{
			System.out.println("Element: " + option.getText());
			
		}

		
		driver.quit();
		
		
	}

}
