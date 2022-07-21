package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

public class Activity5 {
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
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();
        //server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //driver initialization
        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @Test
    public void messageTest(){
        String message = "Hello from Appium";
        //click on start chat button
        driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
        //enter phone number
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("recipient_text_view")));
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("9633205745");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        //enter message
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys(message);
        //click on send button
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
        //verify the message
        String messageText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+message+"']")).getText();
        System.out.println(messageText);
        Assert.assertEquals(messageText,message);

    }
    //Tear down method

    @AfterClass
    public void tearDown(){
        //close app
        driver.quit();
    }

}
