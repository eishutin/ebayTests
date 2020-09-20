package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnderTenDollarsPage extends BasePage {

    @FindBy(xpath = "//a[text()='Tablet Cases']")
    private WebElement tabletCasesButton;

    public UnderTenDollarsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTabletCasesButton(){tabletCasesButton.click();}

}
