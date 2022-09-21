package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get(" https://training-support.net/selenium/dynamic-attributes");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find the username
        WebElement username = driver.findElement(By.xpath("//input[starts-with(@class,'username')]"));
        username.sendKeys("admin");
        //find password field
        WebElement password = driver.findElement(By.xpath("//input[starts-with(@class,'password')]"));
        password.sendKeys("password");
        //find login button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        //get login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        //Close browser
        driver.close();
    }
    }
