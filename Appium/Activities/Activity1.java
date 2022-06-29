package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    //Driver declaration
    AndroidDriver driver;
    //Set up method

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Honor Play");
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.noReset();
        //server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //driver initialization
        driver = new AndroidDriver(serverURL,options);

    }
    //Test method
    @Test
    public void calculatorTest(){
        //find number 4 and click it
        driver.findElement(AppiumBy.id("digit_4")).click();

        // find plus and click it
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();

        //find number 2 and click it
        driver.findElement(AppiumBy.id("digit_2")).click();
        //find equals and click it
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //get and print result
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println(result);
        //Assertions
        Assert.assertEquals(result,"8");

    }


    //Tear down method

    @AfterClass
    public void tearDown(){
        //close app
        driver.quit();
    }
}
