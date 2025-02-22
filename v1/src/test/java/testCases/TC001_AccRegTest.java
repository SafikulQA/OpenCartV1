package testCases;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccRegPage;
import pages.HomePage;

public class TC001_AccRegTest extends BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        
        driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }   

    @AfterMethod
    public void teardown() {
        
        driver.quit();
    }

   
@Test
    public void test() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.clickOnMyAccount();
        home.clickOnRegister();

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='90%'");

        AccRegPage accReg = new AccRegPage(driver);
        accReg.enterFirstName("John");
        accReg.enterLastName("Doe");
        accReg.enterEmail("johndqw2345@gmail.com");
        accReg.enterPassword("abc123");
        Thread.sleep(2000);
        accReg.clickOnPrivacyPolicy();
        Thread.sleep(2000);
        accReg.clickOnContinue();
        Thread.sleep(2000);
        accReg.getRegistrationSuccessMessage();
    }   
    
}