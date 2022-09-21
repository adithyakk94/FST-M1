package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://training-support.net/selenium/selects");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        // find the dropdown
        WebElement dropDown = driver.findElement(By.id("single-select"));
        //selected option
        WebElement selectedText = driver.findElement(By.id("single-value"));
        Select select =  new Select(dropDown);
        //Select the second option using selectByVisibleText
        select.selectByVisibleText("Option 2");
        System.out.println("Second option: "+selectedText.getText());
        //Select the third option using selectByIndex
        select.selectByIndex(3);
        System.out.println("Third option: "+selectedText.getText());
        //Select the fourth option using selectByValue
        select.selectByValue("4");
        System.out.println("Fourth option: "+selectedText.getText());
        //get all the options in the dropdown and print them
        List<WebElement> getOptions = select.getOptions();
        for(WebElement option : getOptions){
            System.out.println(option.getText());
        }
        //Close browser
        driver.close();
    }
}
