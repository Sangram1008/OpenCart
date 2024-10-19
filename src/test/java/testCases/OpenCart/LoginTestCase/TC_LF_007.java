package testCases.OpenCart.LoginTestCase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_007 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;
    MyAccountPage ap;
    Actions action;

    @Test(groups = "Master")
    public void validate_logging_Application_using_Keyboard_keys() {
        logger.info("******* Starting TC_LF_007 *******");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);
            ap = new MyAccountPage(driver);
            action = new Actions(driver);

            hp.clickMyAccount();
            hp.clickLogin();

            lp.setUserName(properties.getProperty("email"));

            action.keyDown(Keys.TAB).build().perform();
            action.keyUp(Keys.TAB).sendKeys(properties.getProperty("password")).build().perform();

            action.keyDown(Keys.TAB).build().perform();
            action.keyUp(Keys.TAB).build().perform();

            action.keyDown(Keys.TAB).build().perform();
            action.keyUp(Keys.TAB).build().perform();

            action.keyDown(Keys.ENTER).build().perform();
            action.keyUp(Keys.ENTER).click().build().perform();

            boolean checkAccountExist = ap.isMyAccountExists();

            Assert.assertEquals(checkAccountExist, true, "Login failed");

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_007 *******");
    }
}
