package tests.day3;


/*
        //now we can get webdriver like this
        //getDriver() method will return webdriver object
        //and we can use reference variable to work with that object
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        //how to  print a source code of the page !!!!!!
        System.out.println(driver.getPageSource());
        //to finish test execution.
        driver.quit();
        }
*/



import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

public class BrowserFactoryTest {


    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com");

        System.out.println(driver.getPageSource());

        driver.quit();
    }
}
