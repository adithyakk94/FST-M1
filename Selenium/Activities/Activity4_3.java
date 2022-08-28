package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance
        WebDriver driver = new FirefoxDriver();
        //Open a browser
        driver.get("https://www.training-support.net/selenium/target-practice");
        //Get the title of the page
        System.out.println("Title of page: " + driver.getTitle());
        //verify the third header text
        WebElement thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']"));
        String thirdHeaderText = thirdHeader.getText();
        System.out.println("Third header Text: "+thirdHeaderText);
        //Find the fifth header on the page and get it's 'colour' CSS Property.
        WebElement fifthHeader = driver.findElement(By.xpath("//h5"));
        String fifthHeaderColor = fifthHeader.getCssValue("color");
        System.out.println("Fifth header color: "+fifthHeaderColor);
        //Find the violet button on the page and print all the class attribute values
        WebElement violetButton = driver.findElement(By.xpath("//button[text()='Violet']"));
        String violetButtonClasses = violetButton.getAttribute("class");
        System.out.println("Violet Button Classes: "+violetButtonClasses);
        //Find the grey button on the page with Absolute XPath
        WebElement greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        String greyButtonText = greyButton.getText();
        System.out.println("Grey Button Text: "+greyButtonText);
        //Close the browser
        driver.close();

    }
}
