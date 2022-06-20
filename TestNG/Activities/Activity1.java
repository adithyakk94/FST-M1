package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeMethod

    public void setUp(){
        //open browser
        driver =  new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @Test
    public void pageVerification() {
        //verify home page
        String homeTitle = driver.getTitle();
        Assert.assertEquals(homeTitle,"Training Support");

        //verify about us page
        driver.findElement(By.id("about-link")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title,"About Training Support");
    }



    @AfterMethod
    public void tearDown(){
        //close browser
        driver.quit();
    }
}
