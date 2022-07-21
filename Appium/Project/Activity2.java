package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
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
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        //server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @Test
    public void noteTest(){
        //click on + button to create new note
        String title = "Meeting Note";
        String description = "Task should be completed by next week";
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        //enter title
        driver.findElement(AppiumBy.id("editable_title")).sendKeys(title);
        //enter description
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys(description);
        //click on back button
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        //verify the added note
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId(title+". "+description+". ")).isDisplayed());
    }

    //Tear down method

    @AfterClass
    public void tearDown() {
        //close app
        driver.quit();
    }

}
