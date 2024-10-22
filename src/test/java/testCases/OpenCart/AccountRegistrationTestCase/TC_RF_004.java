package testCases.OpenCart.AccountRegistrationTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_RF_004 extends BaseClass {

    textFile tf;
    HomePage hp;
    AccountRegistrationPage arp;

    @Test
    public void ValidateNotificationMessagesOnRegisterAccount() {

        logger.info("Starting TC_RF_004");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            arp = new AccountRegistrationPage(driver);

            hp.clickMyAccount();
            hp.clickRegister();
            arp.clickContinue();

            Assert.assertTrue(arp.isInValidFirstNameDisplay(), "First Name is Enter");
            Assert.assertTrue(arp.isInValidLastNameDisplay(), "Last Name is Enter");
            Assert.assertTrue(arp.isInValidEmailDisplay(), "Email is Enter");
            Assert.assertTrue(arp.isInValidTelephoneDisplay(), "Telephone Number is Enter");
            Assert.assertTrue(arp.isInValidPasswordDisplay(), "Password is Entered");
            Assert.assertTrue(arp.isPrivacyErrorMsgDisplay(), "Privacy CheckBox is Checked");


        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("Finished TC_RF_004");
    }
}
