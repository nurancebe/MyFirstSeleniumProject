package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class calisma6 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");

        driver.findElement(By.xpath( "//*[contains(text(),'Incorrect']"));
        driver.findElement(By.xpath( "//*[contains(@title,'Activity Stream')]"));
        driver.quit();
    }
}
