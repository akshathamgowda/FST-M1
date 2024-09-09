package Project;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class addReminder {
	AndroidDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();
		@SuppressWarnings("deprecation")
		URL serverURL=new URL("http://localhost:4723/");
		driver=new AndroidDriver(serverURL,options);
	}
	@Test
	public void googlekeep() throws InterruptedException {
		driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("day2task");
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Task to be done in day2");		
		driver.findElement(AppiumBy.id("com.google.android.keep:id/menu_reminder")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Later today\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		String titleofnote=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\" and @text=\"day2task\"]")).getText();
		Assert.assertEquals(titleofnote, "day2task");
		


}
}


