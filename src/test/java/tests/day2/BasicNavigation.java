package tests.day2;


        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {     //1

        //if you have exception: cannot load a class
        //that means that package name, doesn't match with location of the class itself
        //once bu alttaki webdriver manageri yazmak zorundasin calismaz yoksa cok onemli

        WebDriverManager.chromedriver().setup();  //2


        ChromeDriver driver = new ChromeDriver();  //3


        //to maximize browser
        driver.manage().window().maximize();

        driver.get("http://google.com");           //4  bu ilk dort olmazsa olmaz


        //we want to navigate, to the different page
        //within same browser
        //we not gonna open new browser or new tab
        //URL can be passed as an object
        //or as a string

        //in here we use string
        driver.navigate().to("http://amazon.com");


        //if I want to comeback, to the previous page
        //in here to google
        driver.navigate().back();

        //if I want to know URL of current website
        String url = driver.getCurrentUrl();
        System.out.println(url);

        //selenium cannot close browser automatically
        //for this, we use method close()
        driver.close();
    }
}





