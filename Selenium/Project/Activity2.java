package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        Reporter.log("Started Test");

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
        Reporter.log("Opened Browser");

        //verify the title
        String title = driver.getTitle();
        Assert.assertEquals(title,"SuiteCRM");

    }

    @Test
    public void ImageTest(){
        // Print the url of the header image to the console

      WebElement imageLocator = driver.findElement(By.tagName("img"));
      System.out.println("Url of header image: "+imageLocator.getAttribute("src"));
        Reporter.log("Printed the image url");
    }

    @AfterClass
    public void tearDown(){
        //Close Browser
        driver.close();
        Reporter.log("Closed Browser");
    }
}
