package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class calisma7 {

    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://cybertekschool.com/");
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links "+ links.size());

        List<WebElement> link = driver.findElements(By.xpath("//a[.='Home']" ));
        System.out.println("Number of home links "+ link.size());
        for(WebElement webElement:links) {

            if(!webElement.getText().isEmpty()){
            System.out.println(webElement.getText());
        }
        }

        driver.quit();
    }
}
