package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import org.testng.Assert;

import base.BaseTest;
import pages.AccRegPage;
import pages.HomePage;

public class TC001_AccRegTest extends BaseTest {
   
@Test
    public void test() throws InterruptedException {

        // Click on My Account and then Register
        HomePage home = new HomePage(driver);
        home.clickOnMyAccount();
        home.clickOnRegister();

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='90%'");

        // Enter the registration details
        AccRegPage accReg = new AccRegPage(driver);
        accReg.enterFirstName(randomeString().toUpperCase());
        accReg.enterLastName(randomeString().toUpperCase());
        accReg.enterEmail(randomeString() + ".qa@gamil.com");

        //Here we store the password in a variable so that we can use it later for set confirm password filed also
        String password=randomeAlphaNumericString() + "@";
        accReg.enterPassword(password);

        Thread.sleep(2000);
        accReg.clickOnPrivacyPolicy();
        Thread.sleep(2000);
        accReg.clickOnContinue();
        Thread.sleep(2000);

        // Get success message
        String confmsg=accReg.getRegistrationSuccessMessage();

        // Print the success message in the console
    System.out.println("Registration Success Message: " + confmsg);

        // Assert the expected message
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");
    }   
    
}