package testCases.OpenCart.LoginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass {

    HomePage hp;
    MyAccountPage ap;
    LoginPage lp;

    @Test(groups = "Master")
    public void verify_Login() {

        logger.info("******* Starting Login Test Case *******");

        try {

            hp = new HomePage(driver);
            ap = new MyAccountPage(driver);
            lp = new LoginPage(driver);

            hp.clickMyAccount();
            hp.clickLogin();

            waitElement(lp.login_email, 20, "visibility");
            lp.login(properties.getProperty("email"));

            waitElement(lp.login_password, 20, "visibility");
            lp.password(properties.getProperty("password"));

            waitElement(lp.login_btn, 20, "visibility");
            lp.loginButton();

            waitElement(ap.myAccountText, 50, "visibility");
            boolean checkAccountExist = ap.isMyAccountExists();

            Assert.assertEquals(checkAccountExist, true, "Login failed");

        } catch (Exception e) {
            Assert.fail("Login Test Case Failed");
        }
        logger.info("******* Finished Login Test Case *******");
    }
}
