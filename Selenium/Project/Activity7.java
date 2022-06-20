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

public class Activity7 {
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
    public void leadTest() throws InterruptedException {
        //Locate the sales menu and click on it.
        WebElement sales = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Sales']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(sales));
        sales.click();
        //find the all the options in sales menu
        List<WebElement> lists = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Sales']//following-sibling::ul[@class='dropdown-menu']"));
        for (WebElement list: lists){
            String salesOption  =  list.getText();
            System.out.println(salesOption);
            Thread.sleep(3000);
            //click on Lead option
            if (salesOption.contains("Leads")){
                WebElement leadElement = driver.findElement(By.xpath("//a[text()='Sales']//following-sibling::ul[@class='dropdown-menu']//a[text()='Leads']"));
                WebDriverWait leadWait = new WebDriverWait(driver, Duration.ofSeconds(60));
                leadWait.until(ExpectedConditions.elementToBeClickable(leadElement));
                leadElement.click();
                Thread.sleep(3000);

            }
        }
        Reporter.log("Lead option Clicked");

    }
    @Test(dependsOnMethods = "leadTest")
    public void additionalInfoClick() throws InterruptedException {
        // find the Additional information icon and click on it
        WebDriverWait addWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        addWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text']")));
        WebElement additionalInfo =  driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td//span[@title='Additional Details']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(additionalInfo));
        additionalInfo.click();
        Thread.sleep(2000);
        //Read the popup and print the phone number displayed in it.
        WebElement additionalInfoPopup = driver.findElement(By.xpath("//div[text()='Additional Details']"));
        Assert.assertTrue(additionalInfoPopup.isDisplayed());
        WebElement phoneNumber = driver.findElement(By.xpath("//span[@class='phone']"));
        System.out.println(phoneNumber.getText());
        Reporter.log("Additional info clicked and phone number extracted");
    }

    @AfterClass
    public void tearDown(){
        //Close Browser
        driver.close();
        Reporter.log("Closed Browser");
    }
}
