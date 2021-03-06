package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class validateTitle extends base {
    public WebDriver driver;
    LandingPage landingPage;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized successfully");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to home page");
        landingPage = new LandingPage(driver);
    }

    @Test
    public void validatePageTitle() throws IOException {
        Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
        log.info("Successfully validated title message");
    }

    @Test
    public void validateHeader(){
        Assert.assertTrue(landingPage.getHeader().isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
