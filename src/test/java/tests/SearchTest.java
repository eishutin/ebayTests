package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

    private final String WRONG_SEARCH_DATA = "][poouyhg";
    private final String SEARCH_REQUEST = "iPhone";
    private final String EXPECTED_URL = "Art";
    private final String EXPECTED_RESULT_ON_WRONG_SEARCH_DATA = "No exact matches found";
    private final String ZERO_PRICE = "0";
    private final String EXPECTED_RESULT_ON_SEARCH_FROM_ZERO_TO_SERO_PRICE = "0 results found";
    private final String PRICE = "1";
    private final double EXPECTED_MAX_PRICE_ON_UNDER_TEN_DOLLARS_PAGE = 10.0;

    @Test
    public void checkThatWrongSearchDataGivesNoResult(){
        getHomePage().searchByKeyword(WRONG_SEARCH_DATA);
        assertTrue(getSearchPage().getAnswerOnWrongSearchData().getText().contains(EXPECTED_RESULT_ON_WRONG_SEARCH_DATA));
    }

    @Test
    public void checkThatProductsHeaderContainsSearchRequest(){
        getHomePage().searchByKeyword(SEARCH_REQUEST);
        for (WebElement productHeader: getSearchPage().getSearchResult())
        {
            assertTrue(productHeader.getText().toLowerCase().contains(SEARCH_REQUEST.toLowerCase()));
        }
    }

    @Test
    public void checkThatYouCanGoToOtherPagesFromAllCategoriesMenuInSearchLine(){
        getHomePage().chooseArtInAllCategoriesMenu();
        getHomePage().clickOnSearchButton();
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_URL));
    }

    @Test
    public void checkThatNoProductsWithZeroPrice(){
        getHomePage().clickOnElectronicsButton();
        getElectronicsPage().clickOnSmartWatchesButton();
        getElectronicsPage().waitTime(30);
        assertTrue(getSmartWatchesPage().FindProductFromToPrice(ZERO_PRICE, ZERO_PRICE)
                .get(0).getText().contains(EXPECTED_RESULT_ON_SEARCH_FROM_ZERO_TO_SERO_PRICE));
    }

    @Test
    public void checkThatProductsPriceInsideLimits(){
        getHomePage().clickOnElectronicsButton();
        getElectronicsPage().clickOnSmartWatchesButton();
        getElectronicsPage().waitTime(30);
        List<WebElement> result = getSmartWatchesPage().FindProductFromToPrice(ZERO_PRICE, PRICE);
        for (WebElement productPrice: result)
        {
            double price = Double.parseDouble(productPrice.getText().split("$")[1]);
            assertTrue(price>=Double.parseDouble(ZERO_PRICE)
                    && price<=Double.parseDouble(PRICE));
        }
    }


    //failed - last one
    @Test
    public void checkUnderTenDollarsProductsPrice(){
        getHomePage().clickOnUnerTenDollarsButton();
        getUnderTenDollarsPage().clickOnTabletCasesButton();
        getElectronicsPage().waitTime(30);
        List<WebElement> result = getTabletCasesUnderTenDollarsPage().getProductsPrice();
        getElectronicsPage().waitTime(30);
        for(WebElement productPrice : result)
        {
            double price = Double.parseDouble(productPrice.getText()
                    .substring(productPrice.getText().lastIndexOf("$")+1));
            assertTrue(price<=EXPECTED_MAX_PRICE_ON_UNDER_TEN_DOLLARS_PAGE);
        }
    }
}
