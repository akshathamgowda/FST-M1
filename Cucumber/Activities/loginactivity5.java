package Stepdefintion;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginactivity5 {
    WebDriver driver;
    WebDriverWait wait;
    
    @Given("User is on Login page")
    public void loginPage() {
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    
    @When("User enters username and password")
    public void enterCredentials() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
    
    }

    @When("User enters {string} and {string}")
    public void entercredentialsfrominput(String username, String password) {
        WebElement usernameField =driver.findElement(By.id("username"));
        WebElement passwordField =driver.findElement(By.id("password"));
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
    }
    
    @Then("Read the page title and confirmation message")
    public void readTitleAndHeading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
        
        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
        
        if(confirmMessage.contains("admin")) {
            Assert.assertEquals(confirmMessage, "Welcome Back, admin");
        } else {
            Assert.assertEquals(confirmMessage, "Invalid Credentials");
        }
    }
    
   
    public void closeBrowser() {
        //Close browser
        driver.close();
    }

}
