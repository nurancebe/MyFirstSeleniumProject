//   .sendKeys (""); used for enter the text into input box



package tests.day5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.BrowserUtilities;

public class TestsForNameLocator {

    public static void main(String[] args) {     //1


        WebDriver driver = BrowserFactory.getDriver("chrome"); //2

        driver.manage().window().maximize();
        driver.get(("http://practice.cybertekschool.com/sign_up"));

        driver.findElement(By.name("full_name")).sendKeys("Test User");
        driver.findElement(By.name("email")).sendKeys(("test_email@email.com"));
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtilities.wait(4);
        driver.quit();


    }
}
