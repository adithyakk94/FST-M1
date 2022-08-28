package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        //Open a browser
        driver.get("https://www.training-support.net");
        //Get the title of the page
        System.out.println("Title of page: "+driver.getTitle());
        //find about us link using ID
        WebElement aboutusID = driver.findElement(By.id("about-link"));
        System.out.println("Text in the WebElement using ID: "+aboutusID.getText());

        //find about us link using classname
        WebElement aboutusClass = driver.findElement(By.className("green"));
        System.out.println("Text in the WebElement using Classname: "+aboutusClass.getText());

        //find about us link using linktext
        WebElement aboutusLinkText = driver.findElement(By.linkText("About Us"));
        System.out.println("Text in the WebElement using link text: "+aboutusLinkText.getText());

        //find about us link using cssselector
        WebElement aboutusCssSelector = driver.findElement(By.cssSelector("a#about-link"));
        System.out.println("Text in the WebElement using cssselector: "+aboutusCssSelector.getText());

        Thread.sleep(2000);

        //Close a browser
        driver.close();
    }
}
