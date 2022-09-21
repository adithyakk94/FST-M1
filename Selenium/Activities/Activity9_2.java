package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://training-support.net/selenium/selects");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        // find the multi-select WebElement
        WebElement multiSelect = driver.findElement(By.id("multi-select"));
        //Chosen option
        WebElement chosen = driver.findElement(By.id("multi-value"));
        Select select = new Select(multiSelect);
        if(select.isMultiple()){
            //Select 'JavaScript' by Visible text
            select.selectByVisibleText("Javascript");
            System.out.println(chosen.getText());
            //Select 'NodeJS' by value
            select.selectByValue("node");
            System.out.println(chosen.getText());
            //Select 4,5, and 6 options by index
            for (int i = 4; i <= 6; i++) {
                select.selectByIndex(i);
            }
            System.out.println(chosen.getText());
            //Deselect 'NodeJS' by value
            select.deselectByValue("node");
            System.out.println(chosen.getText());
            //Deselect 7th option by index
            select.deselectByIndex(7);
            System.out.println(chosen.getText());
            //Get all selected options
            List<WebElement> getSelectedOptions = select.getAllSelectedOptions();
            //Print all selected options
            for(WebElement selectedOption : getSelectedOptions) {
                System.out.println("Selected options: " + selectedOption.getText());
            }
            //Deselect all options
            select.deselectAll();
            System.out.println(chosen.getText());
        }
        //Close browser
        driver.close();
    }
}
