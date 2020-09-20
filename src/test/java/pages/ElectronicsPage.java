package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends BasePage{

    @FindBy(xpath = "//div[@class='b-visualnav__grid']//div[text()='Smart Watches']")
    private WebElement SmartWatchesButton;

    public ElectronicsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSmartWatchesButton(){ SmartWatchesButton.click(); }
}
