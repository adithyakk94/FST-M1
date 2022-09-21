package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity8_2 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://training-support.net/selenium/tables");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //Get columns
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        //Get rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));

        //Number of columns
        System.out.println("Number of columns are: " + columns.size());
        //Number of rows
        System.out.println("Number of rows are: " + rows.size());

        //Cell value of second row, second column
        WebElement cellValueBefore = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value(Before sorting): " + cellValueBefore.getText());

        //Sort the table
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]")).click();

        //Print the value of second row, second column again
        WebElement cellValueAfter = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value(After sorting): " + cellValueAfter.getText());

        //Print footer cell value
        WebElement footer = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println("Table footer values: " + footer.getText());

        //Close browser
        driver.close();
    }
}
