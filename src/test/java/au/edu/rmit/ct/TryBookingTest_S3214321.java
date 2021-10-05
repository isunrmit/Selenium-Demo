/**
 Trybooking JUnit/Webdriver Tasks:
 1) Navigate to https://www.trybooking.com/book/search (Links to an external site.) and print-to-screen the featured event titles. Store these titles in a suitable variable in your test case (list? arrays?). Update your test case to use assertEquals to compare these titles with a new test case run. You are expected to show that this test case passes.
 2) Navigate to https://www.trybooking.com/book/search (Links to an external site.) as above and check for featured and events near "you". If any such event has '(Cancelled)' in its title, then this test case should fail.
    Example Event Title: Prahran Market Discovery Trail (CANCELLED)
    Example Event URL: https://www.trybooking.com/events/landing?eid=758678
 3) Navigate to https://www.trybooking.com/BUOMO (Links to an external site.) and book to one of the Monday or Thursday sessions, completing all of any optional data collection questions asked, using your student email ID.
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
class TryBookingTest_S3214321 {
    WebDriver myDriver;


    @Test
    // @Disabled
    @Order(0)
    @DisplayName("Sanity test only")
     void sanityTest1(){
        // When this passes I know I have the webdriver and Junit set up correctly
        String url = "https://www.trybooking.com/book/search";
        myDriver.get(url);
        assertEquals("Buy tickets | TryBooking Australia", myDriver.getTitle());
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