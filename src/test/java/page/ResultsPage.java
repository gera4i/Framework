package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ResultsPage extends AbstractPage {

    private final String selectProductLink = "//*[@id='bx_3966226736_2422']/div/div[2]/div[1]/a/span";
    private final String checkResult = "//h2[contains(@class,'infospice-search-content-title')]";
    public ResultsPage(WebDriver driver, String sneakersName) {
        super(driver);
    }

    public boolean selectProductLink() {
        WebElement productInfoLink = waitForElementLocatedBy(driver,
                By.xpath(selectProductLink),WAIT_TIME_SECONDS);
        return  productInfoLink.isDisplayed();

    }

    public String getCheckResultSeacrh() {
        return waitForElementLocatedBy(driver,By.xpath(checkResult),WAIT_TIME_SECONDS).getText();
    }
}

