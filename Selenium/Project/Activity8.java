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

public class Activity8 {
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

        //click on Login button
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
        Thread.sleep(2000);
        Reporter.log("Login to the application");
    }

    @Test(priority = 1)
    public void accountTest() throws InterruptedException {
        //Locate the sales menu and click on it.
        WebElement sales = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Sales']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(sales));
        sales.click();
        Reporter.log("Located sales option");
        //find the all the options in sales menu
        List<WebElement> lists = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Sales']//following-sibling::ul[@class='dropdown-menu']"));
        for (WebElement list: lists){
            String salesOption  =  list.getText();
            System.out.println(salesOption);
            Thread.sleep(3000);
            //click on Accounts option
            if (salesOption.contains("Accounts")){
                WebElement leadElement = driver.findElement(By.xpath("//a[text()='Sales']//following-sibling::ul[@class='dropdown-menu']//a[text()='Accounts']"));
                WebDriverWait leadWait = new WebDriverWait(driver, Duration.ofSeconds(60));
                leadWait.until(ExpectedConditions.elementToBeClickable(leadElement));
                leadElement.click();
                Thread.sleep(4000);

            }
        }
        Reporter.log("Clicked on account option");

    }
    @Test(dependsOnMethods = "accountTest")
    public void printRows() throws InterruptedException {
        // Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console.
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text']")));
        List<WebElement> rows =  driver.findElements(By.className("oddListRowS1"));
        System.out.println(rows.size());
        int rowCount = rows.size();
        for(int i = 1; i <= rowCount/2; i++) {
            WebElement nameColumn = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[@class='oddListRowS1'][" + i +"]/td[3]"));
            System.out.println(nameColumn.getText());

        }
        Reporter.log("Printed the row values");

    }

    @AfterClass
    public void tearDown(){
        //Close Browser
        driver.close();
        Reporter.log("Closed Browser");
    }
}
