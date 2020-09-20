package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SmartWatchesPage extends BasePage {

    @FindBy(xpath = "//input[@class='x-textrange__input x-textrange__input--from']")
    private WebElement priceFromField;
    @FindBy(xpath = "//input[@class='x-textrange__input x-textrange__input--to']")
    private WebElement priceToField;
    @FindBy(xpath = "//span[@class='page-notice__content']")
    private List<WebElement> negativeSearchResult;
    @FindBy(xpath = "//span[@class='s-item__price']")
    private List<WebElement> searchResult;
    @FindBy(xpath = "//a[@id='gh-la']")
    private WebElement mainIcon;

    public SmartWatchesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> FindProductFromToPrice(String priceFrom, String priceTo){
        priceFromField.sendKeys(priceFrom);
        priceToField.sendKeys(priceTo, Keys.ENTER);
        if(negativeSearchResult==null)
            return searchResult;
        return negativeSearchResult;

    }

    public void clickOnTheMainIcon(){mainIcon.click();}


}
