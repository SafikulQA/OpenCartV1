package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import baseClass.BaseTest;

import org.testng.Assert;

import pages.AccRegPage;
import pages.HomePage;

public class TC001_AccRegTest extends BaseTest {
   
@Test
    public void test() throws InterruptedException {

        logger.info("Test Case TC001_AccRegTest Started");

        try
        {
        // Create object of HomePage
        HomePage home = new HomePage(driver);
        home.clickOnMyAccount();
        logger.info("Clicked on My Account");
        home.clickOnRegister();
        logger.info("Clicked on Register");

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");

        // crete object of AccRegPage
        AccRegPage accReg = new AccRegPage(driver);

        logger.info("Entering Registration Details");
        accReg.enterFirstName(randomeNameString());
        accReg.enterLastName(randomeNameString());
        accReg.enterEmail(randomeEmailString());
        accReg.enterTelephone(randomeNumberString());

        //Here we store the password in a variable so that we can use it later for set confirm password filed also
        String password=randomePasswordString();
        accReg.enterPassword(password);
        accReg.enterConfirmPassword(password);

        Thread.sleep(2000);
        accReg.clickOnPrivacyPolicy();
        Thread.sleep(2000);
        accReg.clickOnContinue();
        Thread.sleep(2000);

        logger.info("Validating expected success message");
        String confmsg=accReg.getRegistrationSuccessMessage();

        // Print the success message in the console
        System.out.println("Registration Success Message: " + confmsg);

        if (confmsg.equals("Your Account Has Been Created!"))
         {
            Assert.assertTrue(true);
            logger.info("Test Case TC001_AccRegTest Passed");
        } 
        else 
        {
            logger.error("Test Case TC001_AccRegTest Failed");
            logger.debug("Debug logs");
            Assert.assertTrue(false); 
        }

        // Assert the expected message
       // Assert.assertEquals(confmsg, "Your Account Has Been Created");
        } 

    catch (Exception e)
    {
        Assert.fail();
    }
    logger.info("Test Case TC001_AccRegTest Completed");
    
}
}