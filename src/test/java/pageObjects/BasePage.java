package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver; // Assign the driver
        PageFactory.initElements(driver, this); // Initialize elements
    }
}
