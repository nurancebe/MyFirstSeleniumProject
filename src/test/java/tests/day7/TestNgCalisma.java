package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TestNgCalisma {

    // @Test
        // public void test (){
        //Assert.assertEquals("appl","apple" ,"Word is not correct! should be apple");}
            //driver.quit();


    @Test(description = "Verifying title of the practice website")
    public void verifyTitle() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong");
        driver.quit();
    }




    @Test(description = "Verify that heading is displayed")     //=====>>>>>   Annotation @Test
    public void verifyHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        Assert.assertTrue(heading.isDisplayed(),"Element is not visible");              // ===========>>>Assertion
        driver.quit();
    }
}

















