package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private final String SEARCH_WATCHES = "watches";
    private final String EMPTY_BUTTON_MESSAGE = "You don't have any items in your cart.";

    @Test
    public void checkThatInEmptyCartNoProducts(){
        getHomePage().clickOnCartButton();
        assertTrue(getCartPage().getEmptyButtonMessage().getText().contains(EMPTY_BUTTON_MESSAGE));

    }
    @Test
    public void checkRemotingProductFromCart(){
        getHomePage().searchByKeyword(SEARCH_WATCHES);
        getSearchPage().clickOnFirstFindProduct();
        getCartPage().waitTime(30);
        getProductPage().clickOnAddToCartButton();
        getCartPage().waitTime(30);
        getCartPage().clickOnRemoteButton();
        assertTrue(getCartPage().getEmptyButtonMessage().getText().contains(EMPTY_BUTTON_MESSAGE));
    }

    @Test
    public void checkThatAddedToCartProductIsInsideCart(){
        getHomePage().searchByKeyword(SEARCH_WATCHES);
        getSearchPage().clickOnFirstFindProduct();
        getCartPage().waitTime(30);
        String productName = getProductPage().getProductName().getText();
        getProductPage().clickOnAddToCartButton();
        getCartPage().waitTime(30);
        assertEquals(getCartPage().getProductName().getText(), productName);
    }
}
