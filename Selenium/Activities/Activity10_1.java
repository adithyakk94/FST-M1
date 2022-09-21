package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://www.training-support.net/selenium/input-events");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find WebElement
        WebElement cube = driver.findElement(By.id("wrapD3Cube"));
        Actions actions = new Actions(driver);
        //Left click
        actions.click(cube).build().perform();
        Thread.sleep(2000);
        WebElement cubeValue =  driver.findElement(By.className("active"));
        System.out.println("Left Click: " + cubeValue.getText());
        //double click
        actions.doubleClick(cube).build().perform();
        Thread.sleep(2000);
        cubeValue =  driver.findElement(By.className("active"));
        System.out.println("Double Click: " + cubeValue.getText());
        //right click
        actions.contextClick(cube).build().perform();
        Thread.sleep(2000);
        cubeValue =  driver.findElement(By.className("active"));
        System.out.println("Right Click: " + cubeValue.getText());
        //Close browser
        driver.close();
    }
}
