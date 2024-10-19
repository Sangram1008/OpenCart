package testCases.OpenCart.LoginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_004 extends BaseClass {


    textFile tf;
    HomePage hp;
    LoginPage lp;
    @Test(groups = "Master")
    public void with_validEmail_inValidPassword() {
        logger.info("******* Starting TC_LF_004 *******");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);

            hp.clickMyAccount();
            hp.clickLogin();
            lp.setUserName(properties.getProperty("email"));
            lp.password(properties.getProperty("inValidPassword"));
            lp.loginButton();

            boolean checkErrorText = lp.checkErrorText(tf.loginErrorText);

            Assert.assertEquals(checkErrorText,true,"checkErrorText is not Present");
        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_004 *******");
    }
}
