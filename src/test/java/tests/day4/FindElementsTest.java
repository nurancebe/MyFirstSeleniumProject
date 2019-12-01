
/*
Agenda:
	WebElement
	findElement
	click()
	sendKeys()
	getText()
	getAttribute()




First, you need to find elements. For this, we have 8 locators.
 id
 name
 tagname
 className
 xpath // will work everywhere and always
 cssSelector
 linkText
 partialLinkText
 As of today, we are using id.
 */

 //// ID LOCATOR
package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtilities;

    public class FindElementsTest {
    public static void main(String[] args) {

       WebDriver driver = BrowserFactory.getDriver("chrome");

       driver.get("http://practice.cybertekschool.com/forgot_password");

       String expectedTitle = driver.getTitle();

        WebElement button = driver.findElement(By.id("form_submit"));

        button.click();

        String actualTitle= driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
            System.out.println("Expected Title: "+expectedTitle);
            System.out.println("Actual Title: "+actualTitle);
        }

        BrowserUtilities.wait(3);
        driver.close();











}}



