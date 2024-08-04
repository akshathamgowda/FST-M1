package Activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;


import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	
	AndroidDriver driver;
  @Test
  public void multiplyTest() {
	  
	  driver.findElement(AppiumBy.id("digit_9")).click();
	  driver.findElement(AppiumBy.accessibilityId("multiply")).click();
	  driver.findElement(AppiumBy.id("digit_5")).click();
	  driver.findElement(AppiumBy.accessibilityId("equals")).click(); 
	  
	  String result = driver.findElement(AppiumBy.id("result_final")).getText();
	  Assert.assertEquals(result, "45");
  }
  @BeforeClass
  public void setUp() throws MalformedURLException {
	  UiAutomator2Options options = new UiAutomator2Options();
	  
	  options.setPlatformName("android");
	  options.setAutomationName("UiAutomator2");
	  options.setAppPackage("com.google.android.calculator");
	  options.setAppActivity("com.android.calculator2.Calculator");
	  options.noReset();
	  
	  URL serverURL = new URL("http://localhost:4723/");
	  driver = new AndroidDriver(serverURL, options);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
