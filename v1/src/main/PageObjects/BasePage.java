import org.openqa.selenium.WebDriver;

// This is parent of all the Page object classes
public class BasePage {

    WebDriver driver;
//Parent class Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        pageFactory.initElements(driver, this);


    }
    
}
