package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shortCutNavigationColumn extends BasePage {

    public shortCutNavigationColumn(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Register' and @class='list-group-item']")
    WebElement navigateRegister;

    public void clickOnNavigateRegister(){
        navigateRegister.click();
    }
}
