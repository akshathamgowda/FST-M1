package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity18 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://v1.training-support.net/selenium/selects");
		//Get the title of the page and print it to the console.
		System.out.println("Print the tile of the page :" + driver.getTitle());
		
		WebElement option = driver.findElement(By.id("multi-select"));
		Select S = new Select(option);
		
		
		//Select the "JavaScript" option using the visible text.
		S.selectByVisibleText("Javascript");
		//Select the 4th, 5th and 6th options using the index.
		S.selectByIndex(4);
		S.selectByIndex(5);
		S.selectByIndex(6);
		//Select the "NodeJS" option using the value.
		S.selectByValue("node");
		Thread.sleep(1000);
		 List<WebElement> selectedOptions = S.getAllSelectedOptions();
	        System.out.println("Selected options are: ");
	        for(WebElement options : selectedOptions) {
	            System.out.println(options.getText());
	        }
		
		//Deselect the 5th option using index.
		S.deselectByIndex(5);
		Thread.sleep(1000);
        System.out.println("After deSelecting option: ");
        List<WebElement> selectedOption = S.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement opt : selectedOption) {
            System.out.println(opt.getText());
        }

		driver.quit();
	}

}
