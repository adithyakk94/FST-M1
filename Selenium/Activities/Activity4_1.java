package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        //Open a browser
        driver.get("https://www.training-support.net");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find the about us element
        driver.findElement(By.xpath("//a[@id='about-link']")).click();
        //get the title of new page
        System.out.println("Title of new page: " + driver.getTitle());
        //Close the browser
        driver.close();
    }
}
