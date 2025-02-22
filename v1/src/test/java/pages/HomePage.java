package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class HomePage extends BasePage {

    WebDriver driver;
    //child class constarctor -1 Mandatory step for every chile page obejct class
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators -2
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement lnkMyAccount;

    @FindBy(xpath="//a[normalize-space()='Register']")
    private WebElement lnkRegister;

    //Action Methods -3
    public void clickOnMyAccount() {
        lnkMyAccount.click();
    }

    public void clickOnRegister() {
        lnkRegister.click();
    }
   
}
