package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find simple alert
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();
        //Switch to alert window
        Alert alert = driver.switchTo().alert();
       // get the text in it
        System.out.println(alert.getText());
        //close the alert
        alert.accept();
        Thread.sleep(2000);
        //Close the Browser
        driver.close();

    }
}
