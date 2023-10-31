package web.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import web.common.BrowserSetup;


public class BaseTest extends BrowserSetup {
    @Parameters({"browser", "url"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, String url) {
        switch (browser.toLowerCase()){
            case "chrome":
                startChrome();
                break;
            case "firefox":
                startFirefox();
                break;
            case "edge":
                startEdge();
                break;
            default:
                startChrome();
                System.out.println("Browser not supported, tests started on Chrome.");
        }
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
