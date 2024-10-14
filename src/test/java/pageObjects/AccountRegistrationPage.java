package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    public WebElement reg_firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    public WebElement reg_lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement reg_email;

    @FindBy(xpath = "//*[@id='input-telephone']")
    public WebElement reg_Telephone;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement reg_password;

    @FindBy(xpath = "//*[@id='input-confirm']")
    public WebElement reg_confirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement reg_agree;

    @FindBy(xpath="//input[@value='Continue']")
    public WebElement reg_continue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
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

    public void setRegTelephone(String phone) {
        reg_Telephone.sendKeys(phone);
    }

    public void setRegPassword(String password) {
        reg_password.sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        reg_confirmPassword.sendKeys(password);
    }

    public void clickAgreeBtn() {
        reg_agree.click();
    }

    public void clickContinue() {

        //sol1
        reg_continue.click();

        //sol2
        //reg_continue.submit();

        //sol3
        //Actions act=new Actions(driver);
        //act.moveToElement(btnContinue).click().perform();

        //sol4
        //JavascriptExecutor js=(JavascriptExecutor)driver;
        //js.executeScript("arguments[0].click();", reg_continue);

        //Sol 5
        //btnContinue.sendKeys(Keys.RETURN);

        //Sol6
        //WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //mywait.until(ExpectedConditions.elementToBeClickable(reg_continue)).click();

    }

    public String getConformation() {
        try {
            return (reg_msgConfirmation.getText());
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
