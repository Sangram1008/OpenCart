package testCases.OpenCart.LoginTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_019 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;
    MyAccountPage ap;
    AccountRegistrationPage arp;
    ProductComponents productComponent;

    @Test
    public void validateNavigationFromLoginPage() {

        logger.info("******* Starting TC_LF_019 *******");

        try {

            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);
            ap = new MyAccountPage(driver);
            arp = new AccountRegistrationPage(driver);

            productComponent = new ProductComponents(driver);

            hp.clickMyAccount();
            hp.clickLogin();

            hp.clickNewCustomer();

            boolean showReg = arp.displayRegisterAccount();

            Assert.assertEquals(showReg, true, "Is Not Showing the Register Account");

            navigateBack();

            productComponent.clickCameras();
            boolean isCameraDisplayed = productComponent.isCameraTextDisplayed();

            Assert.assertEquals(isCameraDisplayed, true, "Camera Is Not Displayed on Page");

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("******* Finished TC_LF_019 *******");
    }
}
