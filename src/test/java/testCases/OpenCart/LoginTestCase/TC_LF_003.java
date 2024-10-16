package testCases.OpenCart.LoginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testCases.OpenCart.baseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_003 extends baseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;

    @Test
    public void with_inValidEmail_validPassword() {
        logger.info("******* Starting TC_LF_003 *******");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);

            hp.clickMyAccount();
            hp.clickLogin();
            lp.login(properties.getProperty("inValidEmail"));
            lp.password(properties.getProperty("password"));
            lp.loginButton();

            boolean checkErrorText = lp.checkErrorText(tf.loginErrorText);

            Assert.assertEquals(checkErrorText,true,"checkErrorText is not Present");

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_003 *******");
    }
}
