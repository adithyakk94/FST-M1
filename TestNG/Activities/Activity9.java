package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
    WebDriver driver;
    @BeforeClass

    public void setUp(){
        //open browser
        driver =  new FirefoxDriver();
        Reporter.log("Starting Test |");
        //Open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened Browser |");
        //Print title of page
        Reporter.log ("Title of page: " + driver.getTitle());
    }
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }
    @Test(priority = 0)
    public void simpleAlertTestCase() throws InterruptedException {
        Reporter.log("simpleAlertTestCase() started |");
        //find simple alert
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();
        Reporter.log("Simple Alert opened");
        //Switch to alert window
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switched focus to alert ");
        // get the text in it
        String alertText = alert.getText();
        System.out.println(alertText);
        Reporter.log("Alert text is: " + alertText + " |");
        Assert.assertEquals("This is a JavaScript Alert!", alertText);
        //close the alert
        alert.accept();
        Reporter.log("Alert closed!!");
        Reporter.log("Test case ended!!");
        Thread.sleep(8000);
    }
    @Test(priority = 1)
    public void confirmAlertTestCase() throws InterruptedException {
        Reporter.log("confirmAlertTestCase() started");
        //find Confirm alert
        WebElement confirmAlert = driver.findElement(By.id("confirm"));
        confirmAlert.click();
        Reporter.log("Confirm Alert opened");
        //Switch to alert window
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switched focus to alert");
        // get the text in it
        String alertText = alert.getText();
        Reporter.log("Alert text is: " + alertText);
        System.out.println(alertText);
        Assert.assertEquals("This is a JavaScript Confirmation!", alertText);
        //close the alert
        alert.accept();
        Reporter.log("Alert closed!!");
        Reporter.log("Test case ended!!");
        Thread.sleep(8000);
    }
    @Test(priority = 2)
    public void promptAlertTestCase() throws InterruptedException {
        Reporter.log("promptAlertTestCase() started");
        //find prompt alert
        WebElement promptAlert = driver.findElement(By.id("prompt"));
        promptAlert.click();
        Reporter.log("Prompt Alert opened");
        //Switch to alert window
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switched focus to alert");
        // get the text in it
        //Get text in the alert box and print it
        String alertText = alert.getText();
        Reporter.log("Alert text is: " + alertText + " |");
        System.out.println(alertText);
        Thread.sleep(2000);
        alert.sendKeys("Yes, you are!");
        Reporter.log("Text entered in prompt alert");
        //Assertion
        Assert.assertEquals("This is a JavaScript Prompt!", alertText);
        //close the alert
        alert.accept();
        Reporter.log("Alert closed!!");
        Reporter.log("Test case ended!!");
        Thread.sleep(8000);

    }
    //close browser
    @AfterClass
    public void tearDown(){
        Reporter.log("Ending Test");
         driver.close();
    }
}
