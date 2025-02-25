package baseClass;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//Below are the imports for Log4j logging should be added to the BaseTest class file Carefully
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

     public WebDriver driver;
     public Logger logger;  //Logger class object for Log4j

    @BeforeMethod
    //This method will be executed before every test method
    public void setup() {
        
        logger=LogManager.getLogger(this.getClass());

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://tutorialsninja.com/demo//");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }   

     @AfterMethod
     //This method will be executed after every test method
    public void teardown() {
        
        driver.quit();
    }  

    //This method will generate random string
    public String randomeNameString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString.toUpperCase());
    }

    public String randomeEmailString() {
        String generatedString = RandomStringUtils.randomAlphanumeric(7);
        return (generatedString + "@gmail.com");
    }

    public String randomeNumberString() {
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return (generatedNumber);

    }


    //This method will generate random alphanumeric string
    public String randomePasswordString() {
        String generatedString = RandomStringUtils.randomAlphanumeric(7);
        return (generatedString + "@");
    }
    
}
