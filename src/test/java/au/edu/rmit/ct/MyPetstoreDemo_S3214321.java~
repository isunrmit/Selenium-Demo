/**
 *  This will be used for W11 Demo as well as part of Assignment Submission
 *  Background reading for DOM:
 *  https://www.w3.org/TR/REC-DOM-Level-1/introduction.html
 *  https://www.w3schools.com/js/js_htmldom.asp
 */
package au.edu.rmit.ct;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Update this class name by replacing S3214321 with your student ID
class MyPetstoreDemo_S3214321 {
    WebDriver myDriver;

    @Test
    @Order(1)
    @DisplayName("Click on hyperlink to Enter Petstore website")
    void test01(){
        String petStoreURL = "https://petstore.octoperf.com";
        myDriver.get(petStoreURL);
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
        System.out.print("Printing text from <a> elements:");
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
        for (WebElement wea : lweTD){
            System.out.print(wea.getText() + ", ");
        }

        // Thread.sleep() is not normally encouraged, but is a quick way to pause browser
        // When you are processing a webpage with Selenium, if the webpage doesnt' load fast enough
        // an exception can be thrown unless you put in some wait time.
        // There are more official ways to handle wait time - we will look at that next weeek.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fail("Task 11.1 : Check that the price is $125.50 using JUnit assertEquals");
        fail("Task 11.2 : Check that the product name is correct (Adult Male Chihuahua) for this product page");
        fail("Task 11.3 Check that the adult male chihuahua is in stock. ( > 0 )");

        /**
         * You will be ask to submit this for your Assignment 3 as well as for other products.
         */
    }

    @Test
    @Order(3)
    @DisplayName("Check Price for another pet you might like to own at product page")
    void checkAnotherPet() {

        fail("Task 11.4 : Check that the price is ??? using JUnit assertEquals");
        fail("Task 11.5 : Check that the product name is correct (???) for this product page");
        fail("Task 11.6 Check that the ??? is in stock. ( > 0 )");
    }

    @Test
    @Order(4)
    @DisplayName("More examples with Xpath")
    void checkChihuahua2(){

        String chihuahuaURL = "https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-26";
        myDriver.get(chihuahuaURL);



        /**
         * If you have time you can look further with this below.
         * In week 11 we will look more at Xpath, which has powerful functionality to find elements and values
         * Xpath is a bit like regular expressions for html elements (DOM tree)
         */

        WebElement we;
        // Here we are using * to check all elements for their enclosed value
        // <p>Like the value here</p>
        // In this example we are searching only for any *  elements, which contains a particular string value
         we = myDriver.findElement(By.xpath("//*[contains(text(),'$125')]"));

         System.out.println("we.toString(): " + we.toString()); // see what it looks like toString()
         System.out.println("we.toString(): " + we.getText()); // see what the text is
        // In this example we are searching only for td elements, which has exact text value
         we = myDriver.findElement(By.xpath("//td[text()='$125.50']"));

    }

    @Test
    @Disabled
    @Order(0)
    @DisplayName("Sanity test only")
     void sanityTest1(){

        String petStoreURL = "https://petstore.octoperf.com";
        myDriver.get(petStoreURL);
        assertEquals("JPetStore Demo", myDriver.getTitle());
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