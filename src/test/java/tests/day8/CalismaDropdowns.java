package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtilities;

import java.util.List;

public class CalismaDropdowns {

    private WebDriver driver;

    @BeforeMethod
     public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }


    @Test(description= "Select option 2 from the dropdown")
    public void test1(){
        WebElement dropdown =driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");


        BrowserUtilities.wait(2);
        //  ====  to check  ====
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
    }


    @Test(description = "Print list of states")
    public void test2(){
        WebElement state =driver.findElement(By.id("state"));
        Select select= new Select(state);
        List<WebElement> states = select.getOptions();
        for(WebElement option : states){
            System.out.println(option.getText());
        }
    }


    @Test(description= "Select your state and verify that state is selected")
    public void test3(){
        WebElement state =driver.findElement(By.id("state"));
        Select select = new Select(state);
        select.selectByValue("MD");
        BrowserUtilities.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Maryland");
    }


    @AfterMethod
    public void teardown(){
    driver.quit();
    }
}
