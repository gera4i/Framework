package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CartPage;
import page.ResultsPage;

public abstract class AbstractPage {

    private final String inputField = "//*[@id=\"title-search-input_fixed\"]";
    private final String buttonGoTo = "//a[contains(@class,'btn btn-default white')]";
    private final String buttonGoToMain = "//div[@class = 'basket_count small clicked empty']";

    protected WebDriver driver;
    protected static final String HOME_URL = "https://www.apple.com/ru/";
    protected final long WAIT_TIME_SECONDS = 20;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public ResultsPage searchForSneakersArticle(String productArticle) {
        WebElement searchInputField = waitForElementLocatedBy(driver,
                By.xpath(inputField), WAIT_TIME_SECONDS);
        searchInputField.sendKeys(productArticle);
        searchInputField.submit();
        return new ResultsPage(driver, productArticle);
    }

    public CartPage openCart() {
        WebElement cartButtonGoTo = waitForElementLocatedBy(driver,
                By.xpath(buttonGoTo),WAIT_TIME_SECONDS);
        cartButtonGoTo.click();
        return new CartPage(driver);
    }

    public CartPage openCartFromMAin() {
        WebElement cartButtonGoTo = waitForElementLocatedBy(driver,
                By.xpath(buttonGoToMain),WAIT_TIME_SECONDS);
        cartButtonGoTo.click();
        return new CartPage(driver);
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by, long time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
