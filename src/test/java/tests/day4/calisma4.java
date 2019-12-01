package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtilities;

public class calisma4 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

       driver.manage().window().maximize();
       driver.get("http://practice.cybertekschool.com/forgot_password");
       String expectedTitle =driver.getTitle();
       WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
        String actualTitle =driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");

        }else {
            System.out.println("Test failed");
            System.out.println("Actual Title: " + actualTitle);
        }
        BrowserUtilities.wait(2);

        driver.close();
    }
}
