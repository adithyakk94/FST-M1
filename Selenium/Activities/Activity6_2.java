package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://training-support.net/selenium/ajax");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find the change content button
        WebElement changeButton = driver.findElement(By.xpath("//button[text()='Change Content']"));
        //click on change content button
        changeButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("ajax-content")), "HELLO!"));
        //getText() and print it
        String helloText = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(helloText);
        //Wait for late text
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        //Get late text and print it
        String lateText = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(lateText);
        //Close browser
        driver.close();

    }
}
