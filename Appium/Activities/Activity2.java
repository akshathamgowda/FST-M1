package Activities;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;

public class Activity2 {
	AndroidDriver driver;
  @Test
  public void f() {
	  driver.get("https://v1.training-support.net/");
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
