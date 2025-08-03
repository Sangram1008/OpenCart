package testCases.OpenCart.LoginTestCase;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

import java.time.Duration;

public class TC_LF_012 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;
    MyAccountPage ap;

    @Test
    public void validate_number_unsucessful_login_attemps() {

        logger.info("******* Starting TC_LF_012 *******");

        try {
            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);
            ap = new MyAccountPage(driver);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            hp.clickMyAccount();
            hp.clickLogin();

            lp.setUserName(properties.getProperty("inValidEmail"));
            lp.password(properties.getProperty("inValidPassword"));

            for (int i = 0; i < 5; i++) {

                lp.loginButton();

                boolean checkErrorText = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(driver -> lp.checkErrorText(tf.loginErrorText));

                Assert.assertTrue(checkErrorText, "Error message not displayed after login attempt " + (i + 1));
            }

            boolean showLoginAttempt = hp.showLoginAttempt();
            Assert.assertTrue(showLoginAttempt, "Not Showing the showLoginAttempt Text");

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_012 *******");
    }
}
