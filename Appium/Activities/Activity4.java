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

public class Activity4 {
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
        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");
        options.noReset();
        //server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //driver initialization
        driver = new AndroidDriver(serverURL,options);

    }

    @Test
    public void addContact(){
        //click on + button to crate new contact
        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
        //Enter first name
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
        //Enter last  name
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Surname']")).sendKeys("Varma");
        //Enter phone number
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");
        //click on save button
        driver.findElement(AppiumBy.id("menu_save")).click();
        //verify the added contact
        String contact = driver.findElement(AppiumBy.id("large_title")).getText();
        Assert.assertEquals(contact,"Aaditya Varma");

    }
    //Tear down method

    @AfterClass
    public void tearDown(){
        //close app
        driver.quit();
    }
}
