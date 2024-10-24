package testCases.OpenCart.LoginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_006 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;

    @Test(groups = "Master")
    public void validate_Forgotten_Password_link() {

        logger.info("******* Starting TC_LF_006 *******");


        tf = new textFile();
        hp = new HomePage(driver);
        lp = new LoginPage(driver);

        try {

            hp.clickMyAccount();
            hp.clickLogin();

            lp.forgetPassWordBtn();

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("******* Finished TC_LF_006 *******");
    }
}
