package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

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
    
}
