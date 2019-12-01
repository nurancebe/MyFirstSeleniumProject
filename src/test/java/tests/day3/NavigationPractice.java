//wait for 3 seconds
//this is our custom method
//since method is static we use class name to call the method
//as a parameter we provide number of seconds (time in seconds)

package tests.day3;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.BrowserUtilities;

public class NavigationPractice {

    public static void main(String[] args) {

        // create a webdriver object to work with browser

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://google.com");


        BrowserUtilities.wait(3);

        //HOW TO PRINT PAGE TITLE??
        System.out.println(driver.getTitle());

        driver.navigate().to("http://amazon.com");


        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.getTitle();  //<title>Google</title>
        //shutdown browser
        driver.quit();


        //driver.close();it there is one tab ayni etkiyi yapar we cannot use browser anymore
        //so we  have to recreate an object of Webdriver
        //driver.quit(); bundan sonra ne yazarsan error verir.this is last stop!!!!
        //driver.get("http://google.com");
    }
}
