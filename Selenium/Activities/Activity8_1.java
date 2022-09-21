package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity8_1 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get("https://training-support.net/selenium/tables");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //Get columns
        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
        //Get rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));

        //Number of columns
        System.out.println("Number of columns are: " + columns.size());
        //Number of rows
        System.out.println("Number of rows are: " + rows.size());

        //Get third row values and print them
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
        for (WebElement thirdRowCellValue : thirdRow) {
            System.out.println("Cell Value: " + thirdRowCellValue.getText());
        }
        //Cell value of second row, second column
        WebElement secondRowCellValue = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value: " + secondRowCellValue.getText());

        //Close browser
        driver.close();

    }
}
