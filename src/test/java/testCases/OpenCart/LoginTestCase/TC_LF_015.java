package testCases.OpenCart.LoginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_015 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;
    MyAccountPage ap;

    @Test
    public void validate_Password_not_visible_in_Page_Source() {

        logger.info("******* Starting TC_LF_015 *******");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);
            ap = new MyAccountPage(driver);

            hp.clickMyAccount();
            hp.clickLogin();

            lp.password(properties.getProperty("password"));

            driver.getPageSource();

            String passWordValue = lp.login_password.getAttribute("value");

            Assert.assertEquals(passWordValue, "password", "Page Source is showing Password in text");

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_012 *******");
    }
}
