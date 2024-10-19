package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='input-email']")
    public WebElement login_email;

    @FindBy(xpath = "//*[@id='input-password']")
    public WebElement login_password;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement login_btn;

    @FindBy(xpath = "//*[@id='account-login']/div[1]")
    public WebElement loginErrorText;

    @FindBy(xpath = "//*[@placeholder='E-Mail Address']")
    public WebElement emailPlaceHolder;

    @FindBy(xpath = "//*[@placeholder='Password']")
    public WebElement passwordPlaceHolder;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Forgotten Password']")
    public WebElement forgetPassWord;

    public void setUserName(String loginValue) {
        login_email.sendKeys(loginValue);
    }

    public void password(String passwordValue) {
        login_password.sendKeys(passwordValue);
    }

    public void loginButton() {
        login_btn.click();
    }

    public boolean checkErrorText(String errorText) {
        try {
            return loginErrorText.getText().equals(errorText);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public WebElement getEmailPlaceHolder() {
        return emailPlaceHolder;
    }

    public WebElement getPasswordPlaceHolder() {
        return passwordPlaceHolder;
    }

    public void forgetPassWordBtn() {
        forgetPassWord.click();
    }
}
