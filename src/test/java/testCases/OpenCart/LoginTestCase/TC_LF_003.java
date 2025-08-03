package testCases.OpenCart.LoginTestCase;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;
import java.time.Duration;

public class TC_LF_003 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;

    @Test(groups = "Master")
    public void with_inValidEmail_validPassword() {
        logger.info("******* Starting TC_LF_003 *******");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);

            hp.clickMyAccount();
            hp.clickLogin();
            lp.setUserName(properties.getProperty("inValidEmail"));
            lp.password(properties.getProperty("password"));
            lp.loginButton();

            boolean checkErrorText = new WebDriverWait(driver,Duration.ofSeconds(20)).until(driver -> lp.checkErrorText(tf.loginErrorText));

            Assert.assertEquals(checkErrorText,true,"checkErrorText is not Present");

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_003 *******");
    }
}
