package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccountText;

    public boolean isMyAccountExists() {
        try {
            return (myAccountText.isDisplayed());
        } catch (NoSuchElementException e) {
            logger.warn("My Account element was not found: " + e.getMessage()); // Log a warning for missing element
            return false;
        } catch (Exception e) {
            logger.error("An unexpected error occurred while checking if 'My Account' exists: ", e);
            return false;
        }
    }

}
