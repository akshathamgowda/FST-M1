package Project;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Createnewnote {
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
		driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("day1task");
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Task to be done in day1");
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		//driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Mark as complete\"])[1]")).click();
		

}
}
