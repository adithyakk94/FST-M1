package activities;

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

public class Activity6 {
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
        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }
    @Test
    public void imageTest(){
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        //Get the number of images shown in the view
        List<WebElement> images = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Image count before scroll:"+images.size());
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        // Scroll and locate elements
        driver.findElement(AppiumBy.androidUIAutomator(
                UiScrollable + ".scrollTextIntoView(\"helen\")"));
        //Get number of images shown on the screen after scrolling.
        images = driver.findElements(AppiumBy.className("android.widget.Image"));
        int imageCount = images.size();
        System.out.println("Image count after the scroll:"+ imageCount);
        //verify the images count
        Assert.assertEquals(imageCount,5);
    }

    //Tear down method

    @AfterClass
    public void tearDown(){
        //close app
        driver.quit();
    }

}
