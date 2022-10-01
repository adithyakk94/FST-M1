package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12_3 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://www.training-support.net/selenium/popups");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //Find the Sign in button and hover over it. Print the tooltip message
        WebElement signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
        Actions action  = new Actions(driver);
        action.moveToElement(signIn).pause(Duration.ofSeconds(1)).build().perform();
        String tooltipText = signIn.getAttribute("data-tooltip");
        System.out.println("Tooltip text: " + tooltipText);
        //Click the button to open the Sign in form
        signIn.click();
        //Wait for modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        //Enter the credentials
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
       //Click login and print the message on the page after logging in.
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(message);
        //Close browser
        driver.close();

    }
}
