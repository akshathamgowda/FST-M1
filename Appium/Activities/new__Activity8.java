package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity8 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void SetUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://v1.training-support.net/selenium");
    }

    @Test
    public void main_Test() {
        Dimension dimen = driver.manage().window().getSize();
        Point start = new Point((int)(dimen.getWidth() * 0.5), (int)(dimen.getHeight() * 0.8));
        Point end = new Point((int)(dimen.getWidth() * 0.5), (int)(dimen.getHeight() * 0.6));
        //wait for the result "Get Started"
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]"))).click();

        BaseAction.doSwipe(driver, start, end, 50);
        //open the To Do list
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")));

        int sizeBeforeTask = driver.findElements(AppiumBy.xpath("//android.widget.TextView")).size();

        //add the task to the list
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys("Add the tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
        //get the number of tasks
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys("Get the number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
        //clear the list
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")).sendKeys("Empty the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();

        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.widget.TextView"));

        //asserting
        Assert.assertEquals(tasks.size(), sizeBeforeTask+3);

        //Selecting the tasks
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add the task to list\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Get the number of tasks\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Empty the list\"]")).click();       
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[3]")).click();
    }
}
