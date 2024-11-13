package testCases.OpenCart.AccountRegistrationTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.shortCutNavigationColumn;
import testBase.BaseClass;

public class TC_RF_007 extends BaseClass {

    HomePage hp;
    AccountRegistrationPage arp;
    shortCutNavigationColumn nc;

    @Test
    public void validateDifferentWays_navigating_RegisterAccount_Page() {
        logger.info("Starting TC_RF_007");
        try {
            hp = new HomePage(driver);
            arp = new AccountRegistrationPage(driver);
            nc = new shortCutNavigationColumn(driver);

            hp.clickMyAccount();
            hp.clickRegister();

            hp.clickMyAccount();
            hp.clickLogin();

            nc.clickOnNavigateRegister();

            arp.displayRegisterAccount();

            Assert.assertTrue(arp.displayRegisterAccount(), "Register Page Is Not Display");
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("Finished TC_RF_007");
    }
}