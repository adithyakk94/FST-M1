package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        //Open a browser
        driver.get("https://training-support.net/selenium/simple-form");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find elements
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        //Enter Text
        firstName.sendKeys("Adithya");
        lastName.sendKeys("KK");
        //find email field
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("adithya.k.k@test.com");
        //find contact field
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("1234567548");
        //find message field
        driver.findElement(By.xpath("//textarea")).sendKeys("This is test message");
        //click submit button
        driver.findElement(By.xpath("//input[@value='submit']")).click();
        Thread.sleep(2000);
        //Close a browser
        driver.close();
    }
}
