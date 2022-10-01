package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://www.training-support.net/selenium/nested-iframes");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //Traverse into the iframe that is on the page.
        driver.switchTo().frame(0);

        //Traverse into the first iframe in that frame.
        driver.switchTo().frame(0);

        //Get heading text in iFrame
        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading1.getText());

        //Switch back to parent page
        driver.switchTo().defaultContent();

        //Switch to first iFrame on the page
        driver.switchTo().frame(0);

        //Switch to second iFrame in that frame
        driver.switchTo().frame(1);

        //Get heading text in iFrame
        WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading2.getText());

        //Close browser
        driver.close();
    }
}
