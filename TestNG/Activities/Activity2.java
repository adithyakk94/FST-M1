package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {
    WebDriver driver;
    @BeforeClass

    public void setUp(){
        //open browser
        driver =  new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test(priority =1)
    public void verifyTitile() {
        //verify title of the page
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice");

    }

    @Test(priority = 2)

    public void findBlackButton(){
        //find black button
        WebElement blackButton =  driver.findElement(By.xpath("//button[@class='ui black button']"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "white");
    }

    @Test(priority = 3 , enabled = false)
    public void findRedButton(){
        //find red button
        WebElement redButton = driver.findElement(By.xpath("//button[@id='red-button']"));
        Assert.assertTrue(redButton.isDisplayed());
    }
    @Test(priority = 4)
    public void findOrangeButton(){
        //find orange button
        WebElement orangeButton = driver.findElement(By.xpath("//button[@class='ui orange button']"));
       if (orangeButton.isDisplayed()) {
           throw new SkipException("this method is skipped");
       }

    }

    @AfterClass
    public void tearDown(){
        //close browser
        driver.quit();
    }
}
