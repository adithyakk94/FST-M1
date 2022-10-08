package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CloseBrowser extends BaseClass{
    @And("^Close the Browser$")
    public void closeTheBrowser() throws Throwable {
        driver.quit();
    }
}
