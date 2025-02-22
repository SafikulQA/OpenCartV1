import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccRegPage extends BasePage {

    //child class constarctor -1 Mandatory step for every chile page obejct class
    public AccRegPage(WebDriver driver) {
        super(driver);
    }

    //Locators -2
    @FindBy(xpath="//input[@id='input-firstname']")
    private WebElement txtFirstName;

    @FindBy(xpath="//input[@id='input-lastname']")
    private WebElement txtLastName;

    @FindBy(xpath="//input[@id='input-email']")
    private WebElement txtEmail;

    @FindBy(xpath="//input[@id='input-password']")
    private WebElement txtPassword;    

    @FindBy(xpath="//input[@name='agree']")
    private WebElement chkPrivacyPolicy;

    @FindBy(xpath="//button[normalize-space()='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement txtSuccessMessage;

    //Action Methods -3
    public void enterFirstName(String firstname) {
        txtFirstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        txtLastName.sendKeys(lastname);
    }
    public void enterEmail(String email) {
        txtEmail.sendKeys(email);   
    }
    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }
    public void clickOnPrivacyPolicy() {
        chkPrivacyPolicy.click();
    }
    public void clickOnContinue() {
        btnContinue.click();

        //solution if avove line is not working
        //btnContinue.submit();
    }

    public String getRegistrationSuccessMessage() {

        try{
        return txtSuccessMessage.getText();
        }
        catch(Exception e){
            return (e.getMessage());
        }
    }

}
