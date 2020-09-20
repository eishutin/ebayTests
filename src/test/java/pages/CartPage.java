package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[@data-test-id='cart-item-link']")
    private WebElement productName;
    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement remoteButton;
    @FindBy(xpath = "//div[@class='font-title-3']")
    private WebElement emptyButtonMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductName(){return productName;}

    public void clickOnRemoteButton(){remoteButton.click();}

    public WebElement getEmptyButtonMessage(){return emptyButtonMessage;}

}
