package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://www.training-support.net/selenium/input-events");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find element
        WebElement keyPress = driver.findElement(By.id("keyPressed"));
        Actions actions = new Actions(driver);
        actions.sendKeys("A").build().perform();
        String pressedKeyText = keyPress.getText();
        System.out.println("Pressed key is: " + pressedKeyText);
        actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        pressedKeyText = keyPress.getText();
        System.out.println("Pressed key is: " + pressedKeyText);

        //Close browser
        driver.close();
    }
}