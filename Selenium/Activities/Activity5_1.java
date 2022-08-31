package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        //Open a browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find the checkbox element
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        //check if checkbox is visible on the page.
        System.out.println("Checkbox is displayed or not: "+ checkBox.isDisplayed());
        //click on remove checkbox button
        driver.findElement(By.id("toggleCheckbox")).click();
        //check if checkbox is visible on the page.
        System.out.println("Checkbox is displayed or not: "+ checkBox.isDisplayed());
        //Close the browser
        driver.close();
    }
}
