import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

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
