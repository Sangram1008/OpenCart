package testCases.OpenCart.LoginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_010 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;
    MyAccountPage ap;

    @Test
    public void validate_LoggingOut_Application_browsing_back_button() {

        logger.info("******* Starting TC_LF_010 *******");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);
            ap = new MyAccountPage(driver);

            hp.clickMyAccount();
            hp.clickLogin();

            lp.setUserName(properties.getProperty("email"));
            lp.password(properties.getProperty("password"));

            lp.loginButton();

            hp.clickMyAccount();
            ap.clickLogOut();

            driver.navigate().back();

            boolean returningCustomerText = hp.getTextReturningCustomer();

            Assert.assertTrue(returningCustomerText, "After logout and clicked button then should not logout");

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_010 *******");

    }
}
