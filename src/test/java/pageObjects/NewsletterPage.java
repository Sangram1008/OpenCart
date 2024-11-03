package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterPage extends BasePage {

    public NewsletterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    public WebElement reg_YesNewsletter;

    @FindBy(xpath = "//label[normalize-space()='No']")
    public WebElement reg_NoNewsletter;

    @FindBy(xpath = "//a[normalize-space()='Subscribe / unsubscribe to newsletter']")
    public WebElement clickSubscribe_UnSubscribe;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement yesNewsletterSubscription;

    @FindBy(xpath = " //input[@value='0']")
    public WebElement noNewsletterSubscription;

    public void clickYesNewsletter(){
        reg_YesNewsletter.click();
    }

    public void clickNoNewsletter(){
        reg_NoNewsletter.click();
    }

    public void navigateToNewsletter(){
        clickSubscribe_UnSubscribe.click();
    }

    public boolean checkYesNewsletterSubscription(){
      return yesNewsletterSubscription.isSelected();
    }

    public boolean checkNoNewsletterSubscription(){
        return noNewsletterSubscription.isSelected();
    }
}
