package au.edu.rmit.ct;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;


class HelloSeleniumFacebook{
	
	@Test
	void checkFacebookTitle() {
        System.setProperty("webdriver.gecko.driver","G:\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://www.facebook.com";
        driver.get(baseUrl);
        System.out.println(driver.getTitle());
        assertEquals("Facebook – log in or sign up", driver.getTitle());
        driver.close();
	}

    @Test
    void checkFacebookEmailInput(){
    	
    	// Of course G:\\drivers\\geckodriver.exe should be replaced with
        // the url of where you stored this.

        System.setProperty("webdriver.gecko.driver","G:\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://www.facebook.com";
        String tagName = "";

        driver.get(baseUrl);
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
        driver.close();
        assertEquals("input", tagName);
    }

}