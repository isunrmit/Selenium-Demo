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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Update this class name by replacing S3214321 with your student ID
class MyPetstoreDemoW12 {
    WebDriver myDriver;

    @Test
    @Order(1)
    @DisplayName("Check authentication, the wrong username/password")
    void test01() throws InterruptedException {

        // myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String petstore = "https://petstore.octoperf.com/actions/Account.action?signonForm=";
        myDriver.get(petstore);

        /*
         * <div id="Content"><ul class="messages"><li>Invalid username or password.  Signon failed.</li></ul>
         * <div id="Catalog"><form method="post" action="/actions/Account.action">
         * <p>Please enter your username and password.</p>
         * <p>Username:<input name="username" id="stripes-2052562751" type="text"><script type="text/javascript">setTimeout(function(){try{var z=document.getElementById('stripes-2052562751');z.focus();z.select();}catch(e){}},1);</script> <br>
         * Password:<input name="password" type="password" value="j2ee"></p>
         * <input name="signon" type="submit" value="Login">
         */
        myDriver.findElement(By.name("username")).clear();
        myDriver.findElement(By.name("username")).sendKeys("Testing1234"); // Enter my user name
        myDriver.findElement(By.name("password")).clear();	// Enter my password
        myDriver.findElement(By.name("password")).sendKeys("Testing1234");	// Enter my password

        // Add sleep if you want to check browser.
        Thread.sleep(3000);
        myDriver.findElement(By.name("signon")).click(); // Click to login



        /* This should fail as password expires regularly
        <ul class="messages"><li>Invalid username or password.  Signon failed.</li></ul>
         */
        assertNotNull(myDriver.findElement(By.className("messages")), "class message not found");
        WebElement we = myDriver.findElement(By.className("messages"));
        assertEquals("Invalid username or password. Signon failed.",  we.getText());


        assertNotNull(myDriver.findElement(By.id("Catalog")), "id Content not found");
        assertNotNull(myDriver.findElement(By.xpath("//div[@id='Catalog']")) );

        assertNotNull(myDriver.findElement(By.id("Content")), "id Content not found");
        assertNotNull(myDriver.findElement(By.xpath("//div[@id='Content']")) );


        // Add sleep if you want to check browser.
        Thread.sleep(3000);


        // Find by ID works fine, but you can't find it by the ID that you see on the browser as that changes
        //  with each session.
        // assertNotNull(myDriver.findElement(By.id("stripes-2052562751")), "id Content not found");
    }
    @Test
    @Order(1)
    @DisplayName("Check authentication, the wrong username/password")
    void test02()  {
        String petstore = "https://petstore.octoperf.com/actions/Account.action?signonForm=";
        myDriver.get(petstore);
        myDriver.findElement(By.name("username")).sendKeys("Testing1234"); // Enter my user name
        myDriver.findElement(By.name("password")).clear();	// Enter my password
        myDriver.findElement(By.name("password")).sendKeys("Testing1234");	// Enter my password
        myDriver.findElement(By.name("signon")).click(); // Click to login

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
         * <div id="Content"><ul class="messages"><li>Invalid username or password.  Signon failed.</li></ul>
         * <div id="Catalog"><form method="post" action="/actions/Account.action">
         * <p>Please enter your username and password.</p>
         * <p>Username:<input name="username" id="stripes-2052562751" type="text"><script type="text/javascript">setTimeout(function(){try{var z=document.getElementById('stripes-2052562751');z.focus();z.select();}catch(e){}},1);</script> <br>
         * Password:<input name="password" type="password" value="j2ee"></p>
         * <input name="signon" type="submit" value="Login">
         */

        WebElement foo = new WebDriverWait(myDriver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.name("q")));
        assertEquals(foo.getText(), "Hello from JavaScript!");

        // assertNotNull(myDriver.findElement(By.id("Content")), "id Content not found");
        // assertNotNull(myDriver.findElement(By.xpath("//div[@id='Content']")) );

    }
    @Test
    @Order(2)
    @DisplayName("Mary gets Order number after Buying Iguana ")
    void maryBuysIguana() throws InterruptedException {
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String iguanaURL = "https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-13";
        myDriver.get(iguanaURL);

        /**
         *  element you are looking for looks like this:
         *  <a href="/actions/Cart.action?addItemToCart=&amp;workingItemId=EST-26" class="Button">Add to Cart</a>
         */

        WebElement we = myDriver.findElement(By.className("Button"));
        if (Objects.equals(we.getText(), "Add to Cart")){
            we.click();
        }


        myDriver.get("https://petstore.octoperf.com/actions/Account.action");

        /*
         * <input name="username" id="stripes-1225316021" type="text">
         * <input name="password" type="password" value="j2ee">
         */

        fail("Task 12.1 Add iguana to the cart");
        fail("Task 12.3 Check to see that order was successful");

        // System.out.println("Mary's order successful. Order number is: " + finalWebElement.getText());
        Thread.sleep(2000);
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