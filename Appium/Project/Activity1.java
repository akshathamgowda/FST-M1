package Project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	
	AndroidDriver driver;
  @Test
  public void f() {
	  //task 1
	  driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click(); 
	  //task 2
	  driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click(); 
	  //task 3
	  driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
	  driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click(); 
	  
	 driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.google.android.apps.tasks:id/task_data\"])[1]")).getText();
	 driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.google.android.apps.tasks:id/task_data\"])[2]")).getText();
	 driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.google.android.apps.tasks:id/task_data\"])[3]")).getText();
  }
  @BeforeClass
  public void setUp() throws MalformedURLException{
UiAutomator2Options options = new UiAutomator2Options();
	  
	  options.setPlatformName("android");
	  options.setAutomationName("UiAutomator2");
	  options.setAppPackage("com.google.android.apps.tasks");
	  options.setAppActivity(".ui.TaskListsActivity");
	  options.noReset();
	  
	  URL serverURL = new URL("http://localhost:4723/");
	  driver = new AndroidDriver(serverURL, options);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
