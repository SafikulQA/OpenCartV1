package base;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

     public WebDriver driver;

    @BeforeMethod
    //This method will be executed before every test method
    public void setup() {
        
        driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }   

     @AfterMethod
     //This method will be executed after every test method
    public void teardown() {
        
        driver.quit();
    }  

    //This method will generate random string
    public String randomeString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }

    //This method will generate random alphanumeric string
    public String randomeAlphaNumericString() {
        String generatedString = RandomStringUtils.randomAlphanumeric(7);
        return (generatedString);
    }
    
}
