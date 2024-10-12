package testCases.AccountRegistration_TC;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class baseClass {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public String randomString(int count) {
        String geratedString = RandomStringUtils.randomAlphabetic(count);
        return geratedString;
    }

    public String randomNumber(int count) {
        String randomNum = RandomStringUtils.randomNumeric(count);
        return randomNum;
    }

    public String randomAlphanumericPassword(int count) {
        String value = RandomStringUtils.randomAlphabetic(count);
        String number = RandomStringUtils.randomNumeric(count);
        return value + "@" + number;
    }
}
