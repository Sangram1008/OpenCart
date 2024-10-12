package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement reg_firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement reg_lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement reg_email;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement reg_password;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement reg_agree;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement reg_continue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created']")
    WebElement reg_msgConfirmation;


    public void setRegFirstName(String name) {
        reg_firstName.sendKeys(name);
    }

    public void setRegLastName(String name) {
        reg_lastName.sendKeys(name);
    }

    public void setRegEmail(String email) {
        reg_email.sendKeys(email);
    }

    public void setRegPassword(String password) {
        reg_password.sendKeys(password);
    }

    public void clickAgreeBtn() {
        reg_agree.click();
    }

    public void clickContinue() {
        reg_continue.click();
    }

    public String getConformation() {
        try {
            return (reg_msgConfirmation.getText());
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
