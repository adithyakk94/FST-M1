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

public class Activity5 {
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

    @Test(priority = 0)
    public void loginTest(){
        //  Find the username and password fields

        WebElement username = driver.findElement(By.xpath("//input[@id='user_name']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='username_password']"));

        // Enter login credentials

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        //click on Login button
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
        Reporter.log("Logged into the application");
    }

    @Test(priority = 1)
    public void navigationColor(){
        //print navigation color
        String navigationColor =  driver.findElement(By.xpath("//div[@id='toolbar']")).getCssValue("color");
        System.out.println(navigationColor);
        Reporter.log("Printed the color of navigation");

    }

    @AfterClass
    public void tearDown(){
        //Close Browser
        driver.close();
        Reporter.log("Closed the Browser");
    }
}
