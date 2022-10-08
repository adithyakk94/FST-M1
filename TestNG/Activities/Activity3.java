package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;
    @BeforeClass

    public void setUp(){
        //open browser
        driver =  new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void loginTest() {
        //identify fields
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        //enter credentials
        username.sendKeys("admin");
        password.sendKeys("password");
        //click login button
        driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();
        //verify login message
        String loginMessage = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
        Assert.assertEquals("Welcome Back, admin",loginMessage);

    }
    //close browser
    @AfterClass
       public void tearDown(){
         driver.quit();
      }
}
