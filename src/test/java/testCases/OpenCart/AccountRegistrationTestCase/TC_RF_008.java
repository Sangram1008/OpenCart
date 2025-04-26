package testCases.OpenCart.AccountRegistrationTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_008 extends BaseClass {

    BaseClass bc = new BaseClass();
    HomePage hp;
    AccountRegistrationPage arp;

    private String firstName = bc.randomString(5);
    private String lastName = bc.randomString(5);
    private String email = randomString(5) + "@gmail.com";
    private String phone = bc.randomNumber(10);
    private String password = randomAlphanumericPassword(4);

    private String confirmationPassWord = "sasdaxasx";

    @Test
    public void validate_RegisteringAccount_entering_differentPasswords_And_ConfirmPassword() {
        logger.info("Starting TC_RF_008");
        try {
            hp = new HomePage(driver);
            arp = new AccountRegistrationPage(driver);

            hp.clickMyAccount();

            hp.clickRegister();

            arp.setRegFirstName(firstName);
            arp.setRegLastName(lastName);
            arp.setRegEmail(email);

            arp.setRegTelephone(phone);

            arp.setRegPassword(password);

            arp.setConfirmPassword(confirmationPassWord);

            arp.clickAgreeBtn();

            arp.clickContinue();

            Assert.assertTrue(arp.inValidConfirmationPassWord(), "Confirmation PassWord Does Not Match");

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("Finished TC_RF_008");
    }
}
