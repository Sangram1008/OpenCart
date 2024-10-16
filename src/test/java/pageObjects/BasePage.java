package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

    protected WebDriver driver;
    protected Logger logger;

    BasePage(WebDriver driver) {
        this.driver = driver; // Assign the driver
        PageFactory.initElements(driver, this); // Initialize elements
        this.logger = LoggerFactory.getLogger(this.getClass());
    }
}
