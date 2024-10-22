//package testCases.OpenCart.LoginTestCase;
//
//import org.openqa.selenium.Cookie;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pageObjects.HomePage;
//import pageObjects.LoginPage;
//import pageObjects.MyAccountPage;
//import testBase.BaseClass;
//import testCases.OpenCart.constantText.textFile;
//
//import java.io.IOException;
//import java.util.Set;
//
//public class TC_LF_017 {
//
//    textFile tf ;
//    HomePage hp;
//    LoginPage lp;
//    MyAccountPage ap;
//    BaseClass bc;
//
//    WebDriver driver;
//
//    @BeforeClass
//    public void open(){
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://tutorialsninja.com/demo/");
//    }
//
//    @AfterClass
//    public void close(){
//        driver.quit();
//    }
//
//    @Test
//    public void validateSessionAfterClosingBrowserWithoutLogout() throws IOException {
//
////        logger.info("******* Starting TC_LF_017 *******");
//
//        try {
//            // Step 1: Initialize page objects and utilities
//            tf = new textFile();
//            hp = new HomePage(driver);
//            lp = new LoginPage(driver);
//            ap = new MyAccountPage(driver);
//            bc = new BaseClass();
//
//            // Step 2: Open the Application URL and navigate to the Login page
//           driver.get("https://tutorialsninja.com/demo/");
//            hp.clickMyAccount();
//            hp.clickLogin();
//
//            // Step 3: Enter valid credentials and login
//            lp.setUserName("pavanoltraining@gmail.com"); // Test Data - Email
//            lp.password("12345"); // Test Data - Password
//            lp.loginButton();
//
//            // Step 4: Capture session cookies to maintain the session after closing the browser
//            Set<Cookie> allCookies = driver.manage().getCookies();
//
//            // Step 5: Close the browser
////            closeBrowserFunction();
//
//            // Step 6: Reopen the browser and navigate to the Application URL again
//            driver.get("https://tutorialsninja.com/demo/");
//
//            // Step 7: Add the previously captured cookies back to the new browser session
//            for (Cookie cookie : allCookies) {
//                driver.manage().addCookie(cookie);
//            }
//
//            // Step 8: Refresh the browser to apply cookies
//            driver.navigate().refresh();
//
//            // Step 9: Validate that the session is still active and user is logged in
//            hp.clickMyAccount();
//            boolean checkLogoutOption = ap.lnkLogout.isDisplayed();
//
//            // Assertion: Verify that the user is still logged in and the Logout option is displayed
//            Assert.assertTrue(checkLogoutOption, "Logged-in session should be maintained, but user is logged out!");
//
//        } catch (Exception e) {
//
//            Assert.fail("Test case failed due to an exception: " + e.getMessage());
//        }
////        logger.info("******* Finished TC_LF_017 *******");
//    }
//}
