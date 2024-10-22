package testCases.OpenCart.AccountRegistrationTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.NewsletterPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_RF_005 extends BaseClass {

    BaseClass bc = new BaseClass();
    textFile tf;
    HomePage hp;
    AccountRegistrationPage arp;
    NewsletterPage nlp;

    private String firstName = bc.randomString(5);
    private String lastName = bc.randomString(5);
    private String email = randomString(5) + "@gmail.com";
    private String phone = bc.randomNumber(10);
    private String password = randomAlphanumericPassword(4);

    @Test
    public void validateRegisteringAccountWhen_Yes_optionSelectedOnNewsletter() {

        logger.info("Starting TC_RF_005");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            arp = new AccountRegistrationPage(driver);
            nlp = new NewsletterPage(driver);

            hp.clickMyAccount();
            hp.clickRegister();

            arp.setRegFirstName(firstName);
            arp.setRegLastName(lastName);
            arp.setRegEmail(email);
            arp.setRegTelephone(phone);
            arp.setRegPassword(password);
            arp.setConfirmPassword(password);

            nlp.clickYesNewsletter();

            waitElement(nlp.reg_YesNewsletter, 50, "visibility");

            arp.clickAgreeBtn();

            waitElement(arp.reg_continue, 20, "scroll");
            arp.clickContinue();

            arp.clickAccountCreatedContinue();

            waitElement(nlp.clickSubscribe_UnSubscribe,30,"scroll");
            nlp.navigateToNewsletter();

            Assert.assertTrue(nlp.checkYesNewsletterSubscription(), "Yes Newsletter Subscription is Not Selected By Default");

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("Finished TC_RF_005");
    }
}
