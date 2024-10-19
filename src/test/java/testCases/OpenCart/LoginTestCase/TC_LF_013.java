package testCases.OpenCart.LoginTestCase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testCases.OpenCart.constantText.textFile;

public class TC_LF_013 extends BaseClass {

    textFile tf;
    HomePage hp;
    LoginPage lp;
    MyAccountPage ap;

    @Test
    public void validate_text_Password_field_toggled_hide_visibility() {

        logger.info("******* Starting TC_LF_013 *******");

        try {
            tf = new textFile();
            hp = new HomePage(driver);
            lp = new LoginPage(driver);
            ap = new MyAccountPage(driver);
            
            hp.clickMyAccount();
            hp.clickLogin();
            
            lp.password(properties.getProperty("password"));

            WebElement passWordVis = lp.login_password;

            String typedValue = passWordVis.getAttribute("type");

            Assert.assertEquals(typedValue,"password","Is not a Visible");
            
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("******* Finished TC_LF_013 *******");
    }
}
