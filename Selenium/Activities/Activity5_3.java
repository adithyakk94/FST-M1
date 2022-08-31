package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        //Open a browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find the input text element
        WebElement textBox = driver.findElement(By.id("input-text"));
        //check if text field is enabled or not
        System.out.println("Text field is enabled or not: "+ textBox.isEnabled());
        //click on enable input button
        driver.findElement(By.id("toggleInput")).click();
        Thread.sleep(2000);
        //check if text field is enabled or not
        System.out.println("Text field is enabled or not: "+ textBox.isEnabled());
        Thread.sleep(2000);
        //Close the browser
        driver.close();
    }
}
