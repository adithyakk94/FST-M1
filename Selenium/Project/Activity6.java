package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity6 {
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
    public void loginTest() throws InterruptedException {
        //  Find the username and password fields

        WebElement username = driver.findElement(By.xpath("//input[@id='user_name']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='username_password']"));

        // Enter login credentials

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        //click on Login button
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
        Thread.sleep(2000);
        Reporter.log("Logged into the application");
    }

    @Test(priority = 1)
    public void activityTest() throws InterruptedException {
       //Locate the navigation menu.
        List<WebElement> lists = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']//li[@class='topnav']"));
        for(WebElement list : lists) {
            String menu = list.getText();
            //verify “Activities” menu item exists and is clickable.
            if(menu.contains("ACTIVITIES")){
                System.out.println(menu);
                //WebElement activity = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Activities']"));
                 if (list.isEnabled()) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
                    wait.until(ExpectedConditions.elementToBeClickable(list));
                    list.click();
                 }
            }
        }
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Activities']//following-sibling::ul[@class='dropdown-menu']")).isDisplayed());
        Reporter.log("Activity menu is clickable");

    }

    @AfterClass
    public void tearDown(){
        //Close Browser
        driver.close();
    }

}
