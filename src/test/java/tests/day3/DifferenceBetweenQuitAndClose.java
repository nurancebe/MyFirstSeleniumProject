package tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenQuitAndClose {

    public static void main (String[]args) throws InterruptedException {
        // this one is for solution for trouble shooting of ==thread.sleep ==throws InterruptedException

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(4000);

        //driver.close();

        driver.quit();
    }
}
