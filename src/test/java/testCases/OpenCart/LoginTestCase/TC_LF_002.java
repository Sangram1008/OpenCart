package testCases.OpenCart.LoginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_002 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;

    @Test(groups = {"Sanity","Master"})
    public void with_invalid_email_password() {
        logger.info("******* Starting TC_LF_002 *******");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);

            hp.clickMyAccount();
            hp.clickLogin();
            lp.setUserName(properties.getProperty("inValidEmail"));
            lp.password(properties.getProperty("inValidPassword"));
            lp.loginButton();

            boolean checkErrorText = lp.checkErrorText(tf.loginErrorText);

            Assert.assertEquals(checkErrorText,true, "checkErrorText failed");

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("******* Ending TC_LF_002 *******");
    }

}
