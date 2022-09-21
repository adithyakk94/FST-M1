package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get(" https://training-support.net/selenium/dynamic-attributes");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find the username
        WebElement username = driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
        username.sendKeys("admin");
        //find password field
        WebElement password = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
        password.sendKeys("password");
        //find confirm password field
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
        password.sendKeys("password");
        //find email field
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        password.sendKeys("test@test.com");

        //find sign up button
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        //get sign up message
        String successMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + successMessage);

        //Close browser
        driver.close();
    }
}
