/**
 JPetstore JUnit/Webdriver Tasks:
 1) Check the pet name, price and check if there is stock for one pet of your choice (outside of Male Chihuahua). (as outlined for W11 prac)
 2) Start a menagerie! Select a specific fish, specific cat, and a third pet (they will have a unique item ID). Add 3 multiples of the first, 2 multiples of the cat, and one of the third pet to the cart. Check the subtotal matches the expected price. You are expected to show that this test case passes.  */
package au.edu.rmit.ct;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Update this class name by replacing S3214321 with your student ID
class JPetstoreTest_S3214321 {
    WebDriver myDriver;


    @Test
    // @Disabled
    @Order(0)
    @DisplayName("Sanity test only")
     void sanityTest1(){
        // When this passes I know I have the webdriver and Junit set up correctly
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