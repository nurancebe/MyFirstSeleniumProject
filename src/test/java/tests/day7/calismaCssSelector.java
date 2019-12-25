package tests.day7;
//index html
//css styl
//js.function
//     css=== element[Attribute='atributevalue']
// xpath ====   //element[@Attribute='atributevalue']

//element tagname demek
// ("#result"));  //====   >     id= 'result'




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import utils.BrowserUtils;

import java.util.List;


public class calismaCssSelector {

        public static void main(String[] args) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/multiple_buttons");

            List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));

            for (WebElement button: buttons){

                button.click();
                BrowserUtils.wait(1);

                WebElement message = driver.findElement(By.cssSelector("#result"));

                System.out.println(message.getText());
            }
            WebElement header = driver.findElement(By.cssSelector(".container > h3"));
            System.out.println(header.getText());

            WebElement p = driver.findElement(By.cssSelector("[class='container'] > p"));
            System.out.println(p.getText());

            driver.quit();
        }
    }









