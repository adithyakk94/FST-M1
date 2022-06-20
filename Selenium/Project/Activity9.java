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

public class Activity9 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        Reporter.log("Starting Test |");

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
        Reporter.log("Entered username and password");

        //click on Login button
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
        Thread.sleep(2000);
        Reporter.log("Clicked login button");
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
                Reporter.log("Located leads option and clicked");

            }
        }

    }
    @Test(dependsOnMethods = "leadTest")
    public void findTheValues() throws InterruptedException {
        // find the table on the page and print the first 10 values in the Name column and the User column of the table to the console.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text']")));
        System.out.println("Name and User of Tables are : ");
        for(int i = 1; i <= 10; i++){
            WebElement nameColumn =  driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[" + i +"]/td[3]"));
            WebElement userColumn =  driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[" + i +"]/td[8]"));
            System.out.println(nameColumn.getText() + " " + userColumn.getText());
        }
        Reporter.log("Values extracted from the table");
    }

    @AfterClass
    public void tearDown(){
        //Close Browser
        driver.close();
        Reporter.log("Closed Browser");
    }
}
