package tests.day9;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class dataprovider {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("Before method!");
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("After method!");
        driver.quit();

    }
    @DataProvider(name = "testData")
    public static Object[][] testData(){
        return new Object[][]{{"https://www.apple.com/", "Apple"}, //1st set of data
                {"http://google.com", "Google"}     //2nd set of data
        };
    }

    @Test(dataProvider = "testData")
    public void testWithDataProvider(String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }


}


