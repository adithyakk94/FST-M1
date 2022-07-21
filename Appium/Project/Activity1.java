package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity1 {
    //Driver declaration
    AndroidDriver driver;
    WebDriverWait wait;
    //Set up method

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Honor Play");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();
        //server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void firstTask() {
        String[] taskLists = {"Complete Activity with Google Tasks",
                             "Complete Activity with Google Keep",
                             "Complete the second Activity Google Keep"};
        for(String taskList: taskLists) {
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Create new task")));
            //click on create new task button
            driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("add_task_title")));
            //enter task name
            driver.findElement(AppiumBy.id("add_task_title")).sendKeys(taskList);
            //click on save button
            driver.findElement(AppiumBy.id("add_task_done")).click();
            //verify the added task
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name']")));
            String task = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name']")).getText();
            Assert.assertEquals(task, taskList);
        }

    }

    //Tear down method

    @AfterClass
    public void tearDown() {
        //close app
        driver.quit();
    }
}
