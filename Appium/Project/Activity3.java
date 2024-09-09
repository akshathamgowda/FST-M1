package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {

	AndroidDriver driver;
    WebDriverWait wait;
    
	@BeforeClass
	public void setUp() throws MalformedURLException{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();
		
		//server address
		URL serverURL = new URL("http://localhost:4723/");	
		//driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test
	public void A() {
		//ADD NOTE OPTION
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		//ADD TIILE
		driver.findElement(AppiumBy.id("editable_title")).sendKeys("Spy Note");
		//ADD TEXT
		driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Hi, This is Spy");
		//CLICK REMINDER
		driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
		//CLICK TIME & DATE
		driver.findElement(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.keep:id/bs_list_view']/android.widget.LinearLayout[1]")).click();
		//Select reminder timings
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/text' and @text='Evening']")).click();
		//Click save
		driver.findElement(AppiumBy.id("save")).click();
		String result = driver.findElement(AppiumBy.accessibilityId("Time reminder Today, 1:00 PM")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "Today, 1:00 PM");
		
	}
	
	 @AfterClass
	    public void tearDown() {
	        // Close the app
	        driver.quit();
	    }
}
