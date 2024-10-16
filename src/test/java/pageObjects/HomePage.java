package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    public WebElement home_myAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    public WebElement home_Register;

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement home_Login;

    public void clickMyAccount() {
        home_myAccount.click();
    }

    public void clickRegister() {
        home_Register.click();
    }

    public void clickLogin(){
        home_Login.click();
    }
}
