/**
 *
 * Name: John Smith (( Update with your name here ))
 * Student ID: s45045012  (( Update with your ID))
 *
 * [OPTIONAL: add any notes or comments here about the code]
 */
package au.edu.rmit.ct;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Update this class name by replacing S3214321 with your student ID
class MyPetstoreDemoW11_S3214321 {
    WebDriver myDriver;

    @Test
    @Order(1)
    @DisplayName("Enter Petstore website")
    void test01(){
        String petStoreURL = "https://petstore.octoperf.com";
        myDriver.get(petStoreURL);
        // Do any asserts here.
    }

    @Test
    @Order(2)
    @DisplayName("Check Price for Adult Male Chihuahua at product page")
    void checkChihuahua1() {

        String chihuahuaURL = "https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-26";
        myDriver.get(chihuahuaURL);

        // WebElement class represents an html tag such as <p> , <a> , <img> <td> for tables etc. even forms
        // ... and this class has methods for you to check content and attributes
        // see the getText() method below to read the text between the opening/closing tags.
        // see the getAttribute("href") method which is used by toString() to read the url

        List<WebElement> lweA = myDriver.findElements(By.tagName("a"));
        System.out.println("Printing text from <a> elements:");
        for (WebElement wea : lweA){
            System.out.print(wea.getText() + ",");
        }
        System.out.println("Printing href attribute values from <a> elements:");
        for (WebElement wea : lweA){
            System.out.println(wea.getAttribute("href") + ",");
        }

        // for this web page (very 1990s) a lot of content are in tables so <td> is a standard cell in the table

        List<WebElement> lweTD = myDriver.findElements(By.tagName("td"));
        System.out.println("Printing text from <td> elements:");
        for (WebElement wea : lweTD){ // each of this are td WebElements
            System.out.print(wea.getText() + ", ");
        }

        // Thread.sleep() is not normally encouraged, but is a quick way to pause browser
        // When you are processing a webpage with Selenium, if the webpage doesn't load fast enough
        // an exception can be thrown unless you put in some wait time.
        // There are more official ways to handle wait time - we will look at that next week.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Write the tests for these below using JUnit assertEquals and the findElements method
        fail("Task 11.1 : Check that the price is $125.50");
        fail("Task 11.2 : Check that the product name is correct (Adult Male Chihuahua) for this product page");
        fail("Task 11.3 : Check that the adult male chihuahua is in stock. ( > 0 ) - or perhaps this should be your first check before 11.1!?");

        /**
         * You will be asked to submit this for your Assignment 3 .
         */
    }

    @Test
    @Order(3)
    @DisplayName("Check Price for any other pet you might like to own at product page")
    void checkAnotherPet() {

        // Write the tests for these below using JUnit assertEquals and the findElements method
        fail("Task 11.4 : Check that the price is ??? using JUnit assertEquals");
        fail("Task 11.5 : Check that the product name is correct (???) for this product page");
        fail("Task 11.6 Check that the ??? is in stock. ( > 0 ) or maybe you should check this before Task 11.4??");

        /**
         * You will be asked to submit this for your Assignment 3 .
         */
    }

    @Test
    // @Disabled
    @Order(0)
    @DisplayName("Sanity test only")
     void sanityTest1(){
        // When this passes I know I have the webdriver and Junit set up correctly
        String petStoreURL = "https://petstore.octoperf.com";
        myDriver.get(petStoreURL);
        // do any sanity check here.
    }

    @BeforeEach
    void setUp() {
        SeleniumDriverFactory sdf =new SeleniumDriverFactory ();
        this.myDriver = sdf.getDriver();
    }

    @AfterEach
    void tearDown() {
        //myDriver.close();
        myDriver.quit();
    }
}