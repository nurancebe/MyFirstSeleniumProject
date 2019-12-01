package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtilities;

//to use for create a website === we need
//javascript executer  interface  ===== muscles action
//css  === skin dizyns
//html ==  sceleton
//mostly used for click and scrolling


public class JSExecutorPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test(description = "Scrolling with JavaScriptExecutor")
    public void test1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0; i< 10; i++){
            //move 500px down
//            Parameters
//            x-coord is the horizontal pixel value that you want to scroll by.
//            y-coord is the vertical pixel value that you want to scroll by.
            js.executeScript("window.scrollBy(0, 500)");
            BrowserUtilities.wait(5);
        }
        BrowserUtilities.wait(5);
    }

    @Test(description = "Scrolling with JSexecutor to specific element")
    public void test2(){
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtilities.wait(5);

//        js code from the browser
//        var footer = document.getElementById('page-footer');
//        footer.scrollIntoView(true);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //this script must scroll, until link element is visible
        //once link element will be visible, it will stop scrolling
        //arguments[0] = means first webelement after comma (link)
        //arguments it's an array of webelements after comma
        //arguments[0] = link web element, it can be any web element
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtilities.wait(5);
    }

    //    var btn1 = document.getElementsByTagName('a')[1];
//    btn1.click()
    @Test(description = "Click with JS executor")
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //Example 1 is a beginning of the phrase <a href='http:'>Example 1.....</a>
        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));

        BrowserUtilities.wait(5);//wait for demo

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //arguments[0] = link1 web element
        //whenever regular selenium methods are not working, I use js executor
        //or for scrolling
        //arguments[0].click() is an alternative for link1.click()
        js.executeScript("arguments[0].click()", link1);

        BrowserUtilities.wait(5);//wait for demo
    }

//this is for print name to the name button
    //document.getElementsByName('full_name')[0].setAttribute('value','My name')

    @Test(description = "Enter text with JS executor")
    public void test4(){
        driver.get("http://practice.cybertekschool.com/sign_up");


        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.name("wooden_spoon"));

        //to create javascriptexecutor object we need to cast webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //enter full name
        //arguments[0].setAttribute('value', 'John Smith') it's the same as name.sendKeys("John Smith");
        BrowserUtilities.wait(5);//wait for demo
        js.executeScript("arguments[0].setAttribute('value', 'John Smith')", name);

        BrowserUtilities.wait(5);//wait for demo
        js.executeScript("arguments[0].setAttribute('value', 'someemail@email.com')", email);

        BrowserUtilities.wait(5);//wait for demo
        js.executeScript("arguments[0].click()", submitButton);

        BrowserUtilities.wait(5);//wait for demo
    }




    @AfterMethod
    public void after(){
        driver.quit();
    }
}

