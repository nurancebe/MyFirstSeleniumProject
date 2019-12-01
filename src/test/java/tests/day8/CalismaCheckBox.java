package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.List;

public class CalismaCheckBox {

    private WebDriver driver;
     @BeforeMethod
    public void setup(){
         driver = BrowserFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com");
         driver.findElement(By.linkText("Checkboxes")).click();
     }


     @Test
     public void test1(){
         int index = 1;
         List <WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
         for(WebElement checkbox :checkboxes){
             if(checkbox.isEnabled() && !checkbox.isSelected()) {
                 checkbox.click();
                 System.out.println("Checkbox #"+index+"was  clicked:");
             }else{
                 System.out.println("Checkbox #"+index+"was not clicked:");
                 index++;
             }
         }
     }







     @AfterMethod
    public void teardown(){
         driver.quit();
     }
}
