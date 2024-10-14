package testCases.AccountRegistration_TC;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends baseClass {

    baseClass bc = new baseClass();

    private String firstName = bc.randomString(5);
    private String lastName = bc.randomString(5);
    private String email = randomString(5) + "@gmail.com";
    private String phone = bc.randomNumber(10);
    private String password = randomAlphanumericPassword(4);
    public String conformationText = "Your Account Has Been Created!";

    @Test
    public void verify_Account_Reg() {

        logger.info("Starting TC001_AccountRegistrationTest");

        try {

            HomePage hp = new HomePage(driver);

            AccountRegistrationPage arp = new AccountRegistrationPage(driver);

            logger.info("Setting Customer Details");

            hp.clickMyAccount();

            hp.clickRegister();

            waitElement(arp.reg_firstName, 10, "visibility");
            arp.setRegFirstName(firstName);

            waitElement(arp.reg_lastName, 10, "visibility");
            arp.setRegLastName(lastName);

            waitElement(arp.reg_email, 10, "visibility");
            arp.setRegEmail(email);

            arp.setRegTelephone(phone);

            waitElement(arp.reg_password, 10, "visibility");
            arp.setRegPassword(password);

            arp.setConfirmPassword(password);

            arp.clickAgreeBtn();

            waitElement(arp.reg_continue, 20, "visibility");
            arp.clickContinue();

            logger.info("Setting Customer Details");

            String conformationMsg = arp.getConformation();
            if (conformationMsg.equals(conformationMsg)) {
                Assert.assertEquals(conformationMsg, conformationText, "conformationMsg Matched");
            } else {
                logger.error("Test Failed");
                logger.debug("Debug logs..");
            }


        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("Finished TC001_AccountRegistrationTest");
    }
}
