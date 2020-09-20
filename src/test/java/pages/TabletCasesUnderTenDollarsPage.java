package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TabletCasesUnderTenDollarsPage extends BasePage {

    @FindBy(xpath = "//span[@class='s-item__price']")
    private List<WebElement> productsPrice;

    public TabletCasesUnderTenDollarsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductsPrice(){return productsPrice;}
}
