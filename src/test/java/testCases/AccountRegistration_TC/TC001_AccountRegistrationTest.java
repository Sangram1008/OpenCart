package testCases.AccountRegistration_TC;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import utilites.randomValueGenerator;

import java.time.Duration;

public class TC001_AccountRegistrationTest extends baseClass {

    baseClass bc = new baseClass();

    private String firstName = bc.randomString(5);
    private String lastName = bc.randomString(5);
    private String email = randomString(5) + "@gmail.com";
    private String password = randomAlphanumericPassword(4);
    private String conformationText = "Your Account Has Been Created!";


    @Test
    public void verify_Account_Reg() {
        HomePage hp = new HomePage(driver);

        AccountRegistrationPage arp = new AccountRegistrationPage(driver);

        hp.clickMyAccount();
        hp.clickRegister();

        arp.setRegFirstName(firstName);
        arp.setRegLastName(lastName);

        arp.setRegEmail(email);
        arp.setRegPassword(password);

        arp.clickAgreeBtn();
        arp.clickContinue();

        String confirmationText = arp.getConformation();
        Assert.assertEquals(confirmationText, this.conformationText);

    }
}
