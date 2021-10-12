package au.edu.rmit.ct;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Update this class name by replacing S3214321 with your student ID
class MyPetstoreW12Demo {
    WebDriver myDriver;

    @Test
    @Order(1)
    @DisplayName("Check authentication, the wrong username/password")
    void test01() throws InterruptedException {

        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

        assertNotNull(myDriver.findElement(By.id("Content")), "id Content not found");
        assertNotNull(myDriver.findElement(By.xpath("//div[@id='Content']")) );

    }
    @Test
    @Order(2)
    @DisplayName("Mary gets Order number after Buying Iguana ")
    void maryBuysIguana() throws InterruptedException {
        //myDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

        assertNotNull(myDriver.findElement(By.id("Content")));
        myDriver.findElement(By.name("username")).clear();
        myDriver.findElement(By.name("username")).sendKeys("Mary1324"); // Enter my user name
        myDriver.findElement(By.name("password")).clear();	// Enter my password
        myDriver.findElement(By.name("password")).sendKeys("Mary1324");	// Enter my password
        myDriver.findElement(By.name("signon")).click(); // Click to login

        myDriver.get("https://petstore.octoperf.com/actions/Cart.action?viewCart=");
        we = myDriver.findElement(By.xpath("//*[contains(text(),'Sub Total')]"));
        // System.out.println(we.getText());
        assertEquals("Sub Total: $18.50",we.getText() );

        myDriver.findElement(By.xpath("//a[contains(text(),'Proceed to Checkout')]")).click();

        myDriver.findElement(By.name("newOrder")).click(); // Click to login

        myDriver.findElement(By.xpath("//a[text()='Confirm']")).click();

        WebElement finalWe = myDriver.findElement(By.xpath("//*[contains(text(),'Order #')]"));
        assertNotNull(finalWe, "Not found order number");
        System.out.println("Mary's order successful: " + finalWe.getText());
        // Thread.sleep(2000);
    }

    @Test
    @Order(3)
    @DisplayName("Just description")
    void test03() throws InterruptedException {
        //myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    @Order(0)
    @DisplayName("Sanity test only")
    void sanityTest1() {

        String petStoreURL = "https://petstore.octoperf.com";
        myDriver.get(petStoreURL);
        assertEquals("JPetStore Demo", myDriver.getTitle());
    }


    @BeforeEach
    void setUp() {
        SeleniumDriverFactory sdf = new SeleniumDriverFactory();
        this.myDriver = sdf.getDriver();
    }

    @AfterEach
    void tearDown() {
        // myDriver.close();
        myDriver.quit();
    }
}