
//it will be used to pause our test execution
//just provide number of seconds as a parameter

package utilities;

public class BrowserUtilities {
    public static void wait(int seconds){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    }
