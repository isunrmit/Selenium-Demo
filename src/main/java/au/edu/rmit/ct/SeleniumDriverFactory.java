/**
 * This class will allow you to separate the webdriver / browser choice from the test classes
 */

package au.edu.rmit.ct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumDriverFactory  {

    // please rename s3214321 this to your own student ID
    SeleniumDriverFactory(){
        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","H:\\drivers\\geckodriver.exe");
    }
    WebDriver getDriver(){
        return new FirefoxDriver();
        // return new ChromeDriver();
    }


}
