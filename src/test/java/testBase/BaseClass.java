package testBase;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;

    // Log4j
    public Logger logger;
    Actions actions;
    public Properties properties = new Properties();

    @BeforeClass(groups = {"Master", "Sanity", "Regression"})
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
//            case "edge":
//                driver = new EdgeDriver();
//                break;
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

    @AfterClass(groups = {"Master", "Sanity", "Regression"})
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

    public String captureScreen(String name) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + name + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }

    public static String getClipboardContents() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            return (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }

    // Method to set clipboard content
    public static void setClipboardContents(String content) {
        StringSelection stringSelection = new StringSelection(content);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
