package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {AndroidDriver driver;
WebDriverWait wait;

@BeforeClass
public void setUp() throws MalformedURLException{
	UiAutomator2Options options = new UiAutomator2Options();
	options.setPlatformName("android");
	options.setAutomationName("UiAutomator2");
	options.setAppPackage("com.android.chrome");
	options.setAppActivity("com.google.android.apps.chrome.Main");
	options.noReset();
	
	//server address
	URL serverURL = new URL("http://localhost:4723/");	
	//driver initialization
	driver = new AndroidDriver(serverURL, options);
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	driver.get("https://v1.training-support.net/selenium");
	
}

@Test
public void test() {
driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")).click();	
wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text='To-Do List  Elements get added at run time']")));
driver.findElement(AppiumBy.xpath("//android.view.View[@text='To-Do List  Elements get added at run time ']")).click();
wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("taskInput")));
//send the task1
driver.findElement(AppiumBy.id("taskInput")).sendKeys("Add tasks to list");
driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
//send 2nd task
driver.findElement(AppiumBy.id("taskInput")).sendKeys("Get number of tasks");
driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
//send 3rd task
driver.findElement(AppiumBy.id("taskInput")).sendKeys("Clear the list");
driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
//strike 1st task
driver.findElement(AppiumBy.xpath("//android.view.View[@text='Add tasks to list']")).click();
//strike 2nd task
driver.findElement(AppiumBy.xpath("//android.view.View[@text='Get number of tasks']")).click();
//strike 3rd task
driver.findElement(AppiumBy.xpath("//android.view.View[@text='Clear the list']")).click();
//claer list
driver.findElement(AppiumBy.xpath("//android.view.View[@text=' Clear List']")).click();
}

 @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }


}
