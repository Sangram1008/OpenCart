package testCases.OpenCart.LoginTestCase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testCases.OpenCart.baseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_008 extends baseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;

    @Test
    public void Validate_emailM_and_password_place_holderText() {
        logger.info("******* Starting TC_LF_008 *******");

        try {

            tf = new textFile();
            hp = new HomePage(super.driver);
            lp = new LoginPage(super.driver);

            hp.clickMyAccount();
            hp.clickLogin();

            String actualEmailPlaceholder = lp.getEmailPlaceHolder().getAttribute("placeholder");
            String actualPasswordPlaceholder = lp.getPasswordPlaceHolder().getAttribute("placeholder");

            Assert.assertEquals(actualEmailPlaceholder, tf.emailPlaceHolder, "Email placeholder text does not match!");
            Assert.assertEquals(actualPasswordPlaceholder, tf.passwordHolder, "Password placeholder text does not match!");

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Starting TC_LF_008 *******");
    }
}
