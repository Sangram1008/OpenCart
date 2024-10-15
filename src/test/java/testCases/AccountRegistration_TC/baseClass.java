package testCases.AccountRegistration_TC;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class baseClass {

    public WebDriver driver;

    // Log4j
    public Logger logger;
    Actions actions;
    public Properties properties = new Properties();

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String br) throws IOException {

        // get Dynamic class
        logger = LogManager.getLogger(this.getClass());

        // Read properties file
        FileReader file = new FileReader("./src//test/resources//config.properties");

        properties.load(file);

        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser..");
                return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Reading URL from properties file
        driver.get(properties.getProperty("appUrl"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public String randomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public String randomNumber(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    public String randomAlphanumericPassword(int count) {
        String value = RandomStringUtils.randomAlphabetic(count);
        String number = RandomStringUtils.randomNumeric(count);
        return value + "@" + number;
    }

    public void waitElement(WebElement element, int count, String conditionType) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(count));

            switch (conditionType.toLowerCase()) {
                case "visibility":
                    wait.until(ExpectedConditions.visibilityOf(element));
                    break;
                case "clickable":
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    break;
                case "presence":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element.toString()))); // Example with By locator
                    break;
                case "invisibility":
                    wait.until(ExpectedConditions.invisibilityOf(element));
                    break;
                case "scroll":
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].scrollIntoView(true);", element);
                    break;
                case "overlay":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader"))); // Example ID of loader
                    element.click();
                    break;
                case "jsclick":
                    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                    jsExecutor.executeScript("arguments[0].click();", element);
                    break;
                case "action":
                    actions = new Actions(driver);
                    actions.moveToElement(element).click().build().perform();
                    break;
                case "javascriptexecutorclick":
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid condition type: " + conditionType);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
