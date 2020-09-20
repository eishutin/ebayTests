package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@class='gh-tb ui-autocomplete-input']")
    private WebElement searchInput;
    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Electronics']")
    private WebElement electronicsButton;
    @FindBy(xpath = "//a[@title='Your shopping cart']")
    private WebElement cart;
    @FindBy(xpath = "//select")
    private WebElement allCategoriesButton;
    @FindBy(xpath = "//select/option[text()='Art']")
    private WebElement artButton;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;
    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab hl-cat-nav__no-sub']//a[text()='Under $10']")
    private WebElement underTenDollarsButton;

    public HomePage(WebDriver driver) { super(driver); }

    public void searchByKeyword(String keyword){searchInput.sendKeys(keyword, Keys.ENTER);}

    public void clickOnSearchButton(){searchButton.click();}

    public void clickOnElectronicsButton(){electronicsButton.click();}

    public void clickOnCartButton(){cart.click();}

    public void chooseArtInAllCategoriesMenu(){
        allCategoriesButton.click();
        artButton.click();
    }

    public void clickOnUnerTenDollarsButton(){underTenDollarsButton.click();}

}
