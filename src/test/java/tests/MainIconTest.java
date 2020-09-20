package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MainIconTest extends BaseTest {

    private final String EXPECTED_URL_AFTER_CLICK_ON_MAIN_ICON = "https://www.ebay.com/";

    @Test
    public void checkThatClickOnTheMainIconReturnYouToTheHomePage(){
        getHomePage().clickOnElectronicsButton();
        getElectronicsPage().clickOnSmartWatchesButton();
        getSmartWatchesPage().clickOnTheMainIcon();
        assertEquals(getDriver().getCurrentUrl(), EXPECTED_URL_AFTER_CLICK_ON_MAIN_ICON);
    }
}
