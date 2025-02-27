package baseClass;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

     public WebDriver driver;
     public Logger logger;  //Logger class object for log4j2

    @BeforeMethod
    @Parameters({"os", "browser"})
    
    public void setup(String os, String browser)        //This method will be executed before every test method
     {
    
        logger = LogManager.getLogger(this.getClass().getName());       //log4j2

        //driver = new ChromeDriver(); //This is the old way of creating driver object
        // below code is to create driver object based on the browser parameter passed from testng.xml file
        switch (browser.toLowerCase())
         {
            case "chrome":  driver = new ChromeDriver(); break;
            case "edge":    driver = new EdgeDriver();  break;
            case "firefox": driver = new FirefoxDriver(); break;
        
            default: System.out.println("Please provide correct browser name");
                return;
        }

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
