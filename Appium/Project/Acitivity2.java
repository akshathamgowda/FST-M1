package Project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Acitivity2 {
	AndroidDriver driver;

  @Test
  public void f() {
	  driver.findElement(AppiumBy.accessibilityId("New text note")).click();
	  driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Family");
	  driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Hai Mamatha, Vikram, Vivan");
	  driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
	 
	
	  List<WebElement> notes = driver.findElements(AppiumBy.id("com.google.android.keep:id/index_note_title"));
      boolean noteAdded = false;
      for (WebElement note : notes) {
          if (note.getText().equals("Family")) {
              noteAdded = true;
              break;
          }
      }
      Assert.assertTrue(noteAdded, "The note was not added.");
  }
	  
	  
	  
  @BeforeClass
  public void setUp() throws MalformedURLException{
UiAutomator2Options options = new UiAutomator2Options();
	  
	  options.setPlatformName("android");
	  options.setAutomationName("UiAutomator2");
	  options.setAppPackage("com.google.android.keep");
	  options.setAppActivity(".activities.BrowseActivity");
	  options.noReset();
	  
	  URL serverURL = new URL("http://localhost:4723/");
	  driver = new AndroidDriver(serverURL, options);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
