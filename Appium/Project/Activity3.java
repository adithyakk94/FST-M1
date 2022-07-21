package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3 {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium");
    }
    @Test
    public void addTask() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        // Scroll and locate elements
        driver.findElement(AppiumBy.androidUIAutomator(
                UiScrollable + ".scrollTextIntoView(\"To-Do List\")")).click();
        String[] tasks = {"Add tasks to list",
                "Get number of tasks",
                "Clear the list"};
        for (String task : tasks) {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
            //enter the task
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys(task);
            //click on add task button
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='" + task + "']")));
            //strike out the added task
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + task + "']")).click();
        }
        //clear the list
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();
        //verify the added tasks are cleared
        //Assert.assertFalse(driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']")).isDisplayed());
        List<WebElement> lists = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']"));
        Assert.assertTrue(lists.isEmpty());
    }
    //Tear down method

    @AfterClass
    public void tearDown() {
        //close app
        driver.quit();
    }
}
