package testCases.OpenCart.LoginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilites.dataProviders;

public class login_DataDriven extends BaseClass {

    HomePage hp;
    MyAccountPage ap;
    LoginPage lp;

    // dataProviders.class is used because it is used in other class
    @Test(dataProvider = "LoginData", dataProviderClass = dataProviders.class)
    // getting data provider from different class
    public void verify_loginDDT(String email, String pwd, String exp) {
        logger.info("***** stating login_DataDriven ******");

        try {

            hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            lp = new LoginPage(driver);
            lp.setUserName(email);
            lp.password(pwd);
            lp.loginButton();

            //MyAccount
            ap = new MyAccountPage(driver);
            boolean targetPage = ap.isMyAccountExists();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    ap.clickLogOut();
                    Assert.assertTrue(true);

                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    ap.clickLogOut();
                    Assert.assertTrue(false);

                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished login_DataDriven ******");

    }
}
