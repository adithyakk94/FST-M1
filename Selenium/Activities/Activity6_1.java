package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find the checkbox element
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        //click on toggle button
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
        toggleButton.click();
        //Wait for checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOf(checkBox));
        //Click toggle button again
        toggleButton.click();
        //Wait for checkbox to appear
        wait.until(ExpectedConditions.visibilityOf(checkBox));
        //click on checkbox button
        checkBox.click();
        System.out.println("Checkbox is displayed or not: "+ checkBox.isDisplayed());
        //Close the browser
        driver.close();
    }
}
