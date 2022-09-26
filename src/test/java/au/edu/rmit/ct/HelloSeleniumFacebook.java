package au.edu.rmit.ct;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloSeleniumFacebook{


    @Test
    @Order(1)
    @DisplayName("Use Firefox Web Driver to check retrieval of Facebook Homepage")
    void checkFacebookTitle() {

        // Step 1. Set system property for either chrome driver (for Chrome browser ) or gecko driver (for Firefox browser)
        System.setProperty("webdriver.gecko.driver","H:\\drivers\\geckodriver.exe");

        // Step 2. Instantiate the Web Driver as your driver
        WebDriver myDriver = new FirefoxDriver();

        // Step 3. name the url you want to test.
        String baseUrl = "http://www.facebook.com";

        // Step 4. Direct your driver
        myDriver.get(baseUrl);

        // Step 5. use Junit assertions to make sure you have the right page
        assertEquals("Facebook – log in or sign up", myDriver.getTitle());

        // Step 6. Finally close your session.
        myDriver.close();
    }

    @Test
    @Order(2)
    @DisplayName("Use Chrome Web Driver to check email input field of Facebook page")
    void checkFacebookEmailInput(){

        // Of course G:\\drivers\\geckodriver.exe should be replaced with
        // the url of where you stored this.
        // Step 1. Set system property for either chrome driver or gecko driver (for Firefox browser)
        System.setProperty("webdriver.chrome.driver","H:\\drivers\\chromedriver.exe");

        // Step 2. Instantiate the Web Driver as your driver

        WebDriver myDriver = new ChromeDriver();

        // Step 3. name the url you want to test.
        String baseUrl = "http://www.facebook.com";

        // Step 4. Direct your driver
        myDriver.get(baseUrl);
        String tagName = myDriver.findElement(By.id("email")).getTagName();

        // Step 5. use Junit assertions to make sure you have the right page
        assertEquals("input", tagName);


        // Step 6. Finally close your session. But we want to pause for 3 seconds first

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myDriver.close();






    }

}
