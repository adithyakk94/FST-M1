package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver;
    Actions builder;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        builder = new Actions(driver);

        //Open browser
        driver.get("https://www.training-support.net/selenium/sliders");
    }

    @Test(priority = 0)
    public void sliderToMiddleTest() {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Clicking on the slider element moves it to the middle
        slider.click();

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Middle value: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "50");
    }

    @Test(priority = 1)
    public void sliderToMaxTest() {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Maximum value: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "100");
    }

    @Test(priority = 2)
    public void sliderToMinTest() {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Minimum value: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "0");
    }

    @Test(priority = 3)
    public void sliderTo30Test() {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Value at the 30% mark of the slider " + volumeLevel);

        Assert.assertEquals(volumeLevel, "30");
    }

    @Test(priority = 4)
    public void sliderTo80Test() {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(45, 0).release().build().perform();

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Value at the 80% mark of the slider: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "80");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        //driver.close();
    }
}
