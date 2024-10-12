package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class=\"list-inline-item\"]//span[normalize-space()='My Account']")
    public WebElement home_myAccount;

    @FindBy(xpath = "//a[normalize-space()='Register'][@class='dropdown-item']")
    public WebElement home_Register;

    public void clickMyAccount() {
        home_myAccount.click();
    }

    public void clickRegister() {
        home_Register.click();
    }
}
