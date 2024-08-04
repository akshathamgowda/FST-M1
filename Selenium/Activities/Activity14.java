package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity14 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/tables");
		//Get the title of the page and print it to the console.
		System.out.println("Print the tile of the page :" + driver.getTitle());
		
		//Find the number of rows and columns in the table and print them.
        List<WebElement> rows =  driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));	
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        
        System.out.println("No of Columns : " +cols.size());
        System.out.println("No of Rows : " +rows.size());
        
        //Find and print the cell value at the second row second column.
        WebElement cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Value of cell for the Second row and second column : " + cellValue.getText());
        
        //Click the header of the first column to sort by name
        Thread.sleep(2000);
        //sorting the table
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();
        Thread.sleep(2000);
        
        cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        //Find and print the cell value at the second row second column again
        System.out.println("After sorting the Value of cell for the Second row and second column : " + cellValue.getText());

        List<WebElement> footerValue = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        
        System.out.println("The cell values of footer :");
        
        for(WebElement foot : footerValue)
        {
        	System.out.println(foot.getText());
        }
        

        
        driver.quit();

	}

}
