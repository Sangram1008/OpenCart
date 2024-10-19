package testCases.OpenCart.LoginTestCase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_014 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;
    MyAccountPage ap;

    @Test
    public void validate_copying_of_text_entered_into_the_Password_field() {

        logger.info("******* Starting TC_LF_014 *******");

        try {
            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);
            ap = new MyAccountPage(driver);

            Actions action = new Actions(driver);

            hp.clickMyAccount();
            hp.clickLogin();

            lp.password(properties.getProperty("password"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String copiedText = (String) js.executeScript("return window.getSelection().toString();");

            Assert.assertTrue(copiedText.isEmpty(), "Password text should not be copied via right-click");

            action.click(lp.login_password).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

            String copiedTextAfterCtrlC = (String) js.executeScript("return window.getSelection().toString();");
            Assert.assertTrue(copiedTextAfterCtrlC.isEmpty(), "Password text should not be copied via Ctrl+C");
        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_014 *******");
    }
}
