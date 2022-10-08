package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;
    @BeforeClass(alwaysRun = true)

    public void setUp(){
        //open browser
        driver =  new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/target-practice");
    }

    @Test(priority = 0, groups = {"HeaderTests","ButtonTests"})
    public void verifyTitle(){
        //verify the title
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Target Practice");

    }

    @Test(priority = 1, groups = {"HeaderTests"})
    public void thirdHeaderTest(){
        //verify the third header text
        WebElement thirdHeader = driver.findElement(By.id("third-header"));
        String thirdHeaderText = thirdHeader.getText();
        System.out.println(thirdHeaderText);
        Assert.assertEquals(thirdHeaderText,"Third header");
    }

    @Test(priority = 2,groups = {"HeaderTests"})
    public void fifthHeaderTest(){
        WebElement fifthHeader = driver.findElement(By.xpath("//h5[@class='ui green header']"));
        String fifthHeaderColor = fifthHeader.getCssValue("color");
        System.out.println(fifthHeaderColor);
        Assert.assertEquals(fifthHeaderColor,"rgb(33, 186, 69)");
    }

    @Test(priority = 3, groups = {"ButtonTests"})
    public void oliveButtonTest(){
        WebElement oliveButton = driver.findElement(By.xpath("//button[@class='ui olive button']"));
        String oliveButtonText = oliveButton.getText();
        System.out.println(oliveButtonText);
        Assert.assertEquals(oliveButtonText,"Olive");

    }
    @Test(priority = 4, groups = {"ButtonTests"})
    public void buttonTest(){
        WebElement brownButton = driver.findElement(By.xpath(" //button[@class='ui brown button']"));
        String brownButtonColor = brownButton.getCssValue("color");
        System.out.println(brownButtonColor);
        Assert.assertEquals(brownButtonColor,"rgb(255, 255, 255)");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //close browser
        driver.quit();
    }
}
