package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://v1.training-support.net/selenium/tables");
		//Get the title of the page and print it to the console.
		System.out.println("Print the tile of the page :" + driver.getTitle());
		//Find the number of rows and columns in the table and print them.
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
		System.out.println("The columns size is :" + cols.size()); 
	    //Find and print all the cell values in the third row of the table.
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
		System.out.println("Printing the cell values for Row 3: ");
		for(WebElement cell : rows) {
			
			System.out.println(cell.getText());
		}
		
		//Find and print the cell value at the second row second column.
//		WebElement colValue = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
//		System.out.println("Printing the cell value for second row second column: " +colValue.getText());

		 WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
	        System.out.println("Second row, second cell value: " + cellValue.getText());

		driver.quit();

	}

}
