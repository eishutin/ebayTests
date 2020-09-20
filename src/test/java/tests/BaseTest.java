package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

public class BaseTest {

    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage(){
        return new HomePage(getDriver());
    }

    public SearchPage getSearchPage(){
        return new SearchPage(getDriver());
    }

    public SmartWatchesPage getSmartWatchesPage(){
        return new SmartWatchesPage(getDriver());
    }

    public ElectronicsPage getElectronicsPage(){
        return new ElectronicsPage(getDriver());
    }

    public ProductPage getProductPage() {return new ProductPage(getDriver());}

    public CartPage getCartPage(){return new CartPage(getDriver());}

    public UnderTenDollarsPage getUnderTenDollarsPage(){return new UnderTenDollarsPage(getDriver());}

    public TabletCasesUnderTenDollarsPage getTabletCasesUnderTenDollarsPage(){
        return new TabletCasesUnderTenDollarsPage(getDriver());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
