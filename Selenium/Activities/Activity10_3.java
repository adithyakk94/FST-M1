package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_3 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser
        driver.get(" https://training-support.net/selenium/drag-drop");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //find the ball
        WebElement ball = driver.findElement(By.id("draggable"));
        //find dropzone1
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        //find dropzone2
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        Actions actions = new Actions(driver);
        //Move to dropzone1
        actions.dragAndDrop(ball,dropzone1).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone1, "background-color"));
        String dropZone1Color = dropzone1.getCssValue("background-color");
        System.out.println("DropZone1 Color: "+dropZone1Color);
        if(dropZone1Color.equals("rgb(33, 186, 69)")){
            System.out.println("Ball is entered in dropzone 1");
        }

        //Move to dropzone2
        actions.dragAndDrop(ball,dropzone2).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone1, "background-color"));
        String dropZone2Color = dropzone1.getCssValue("background-color");
        System.out.println("DropZone2 Color: "+dropZone2Color);
        if(dropZone2Color.equals("rgb(33, 186, 69)")){
            System.out.println("Ball is entered in dropzone 2");
        }
        // Close the browser
        driver.close();


    }
}
