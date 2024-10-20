package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductComponents extends BasePage {

    public ProductComponents(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    public WebElement product_Desktop;

    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    public WebElement product_Laptop_AND_Notebooks;

    @FindBy(xpath = "//a[normalize-space()='Components']")
    public WebElement product_Components;

    @FindBy(xpath = "//a[normalize-space()='Tablets']")
    public WebElement product_Tablets;

    @FindBy(xpath = "//a[normalize-space()='Software']")
    public WebElement product_Software;

    @FindBy(xpath = "//a[normalize-space()='Phones & PDAs']")
    public WebElement product_PhoneAndPDA;

    @FindBy(xpath = "//a[normalize-space()='Cameras'][1]")
    public WebElement product_Cameras;

    @FindBy(xpath = "//h2[normalize-space()='Cameras']")
    public WebElement cameraText;

    @FindBy(xpath = "//a[normalize-space()='MP3 Players']")
    public WebElement product_MP3;


    public void clickOnDesktop() {
        product_Desktop.click();
    }

    public void clickLaptopAndNotebooks() {
        product_Laptop_AND_Notebooks.click();
    }

    public void clickComponent() {
        product_Components.click();
    }

    public void clickTablets() {
        product_Tablets.click();
    }

    public void clickSoftWare() {
        product_Software.click();
    }

    public void clickPhoneAndPDA() {
        product_PhoneAndPDA.click();
    }

    public void clickCameras() {
        product_Cameras.click();
    }

    public boolean isCameraTextDisplayed() {
        return cameraText.isDisplayed();
    }

    public void clickMP3() {
        product_MP3.click();
    }
}
