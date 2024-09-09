package Project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class NewTask {
	AndroidDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();
		@SuppressWarnings("deprecation")
		URL serverURL=new URL("http://localhost:4723/");
		driver=new AndroidDriver(serverURL,options);
	}

		
		@Test
	public void addnewTask() throws InterruptedException {
			Thread.sleep(5000);
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
			Thread.sleep(5000);
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Google Tasks");
			WebElement saved=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"));
			saved.click();
			String taskavailable=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name")).getText();
			
			Assert.assertEquals(taskavailable,"Google Tasks");	
			driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Mark as complete\"])[1]")).click();
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
			Thread.sleep(5000);
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Google Keep");
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
			
			//driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name")).click();
			
			String task2available=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Google Keep\"]")).getText();
			
			Assert.assertEquals(task2available,"Google Keep");	
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_item_completed_check")).click();

		}
//		
	}
		
