package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C://Users//Kamal//Downloads//UIAutomationFramework//src//main//resources//data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);
        
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C://Users//Kamal//Downloads//UIAutomationFramework//src//main//resources//Browsers//chromedriver1.exe");
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("IE")){
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}