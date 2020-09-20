package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//h3[@class='srp-save-null-search__heading']")
    private WebElement answerOnWrongSearchData;
    @FindBy(xpath = "//h3[@class='s-item__title']")
    private List<WebElement> searchResults;


    public SearchPage(WebDriver driver) { super(driver); }

    public WebElement getAnswerOnWrongSearchData(){return answerOnWrongSearchData;}

    public List<WebElement> getSearchResult() {
        return searchResults;
    }

    public void clickOnFirstFindProduct(){ searchResults.get(0).click();}
}
