package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h1[@class='it-ttl']")
    private WebElement productName;
    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@title='Your shopping cart']")
    private WebElement cart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductName(){ return productName;}

    public void clickOnAddToCartButton(){addToCartButton.click();}

    public void clickOnCart(){cart.click();}


}
