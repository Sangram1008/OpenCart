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

public class TC_LF_009 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;
    MyAccountPage mcp;

    @Test()
    public void validate_Logging_Application_and_browsing_back_using_back_button() {

        logger.info("******* Starting TC_LF_009 *******");

        try {
            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);

            hp.clickMyAccount();
            hp.clickLogin();

            lp.setUserName(properties.getProperty("email"));
            lp.password(properties.getProperty("password"));

            lp.loginButton();

            driver.navigate().back();

            boolean accountPageExists = new WebDriverWait(driver, Duration.ofSeconds(50)).until(driver -> mcp.isMyAccountExists());

            Assert.assertTrue(accountPageExists, "User was logged out after clicking browser back button.");

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_009 *******");
    }
}
