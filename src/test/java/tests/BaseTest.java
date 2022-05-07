package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SearchResultPage;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {


    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String SITE_URL = "https://www.ctrs.com.ua/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("opera") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(SITE_URL);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }


    public SearchResultPage getSearchResultPage(){
        return new SearchResultPage(getDriver());
    }
}
