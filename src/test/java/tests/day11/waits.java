package tests.day11;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class waits {


    private WebDriver driver;

    @BeforeMethod

    public void setup() {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }



    @Test(description = "Implicit wait example")


    public void test1() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();

        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();

        WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }



    @Test(description = "Explicit wait example")


    public void test2() {

        driver.findElement(By.linkText("Dynamic Loading")).click();

        driver.findElement(By.partialLinkText("Example 1")).click();

        driver.findElement(By.tagName("button")).click();

        WebElement userNameInputBox = driver.findElement(By.id("username"));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tomsmith");
        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        WebElement message = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }




    @Test(description = "Explicit wait example") // overlay screen


    public void test3() {


        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();


        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));

        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

        WebElement userNameInputBox = driver.findElement(By.id("username"));

        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));

        userNameInputBox.sendKeys("tomsmith");

        WebElement passwordInputBox = driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        WebElement message = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }





    @Test(description = "Fluent wait example")


    public void test4() {


        driver.findElement(By.linkText("Dynamic Loading")).click();

        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();

        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class);

        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("finish"));
            }
        });
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
