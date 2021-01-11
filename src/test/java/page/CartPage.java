package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends AbstractPage {

    private final String productArticle = "//tr[1]//div[@class = 'basket-item-property-custom-value']";
    private final String productSecondArticle = "//tr[2]//div[@class = 'basket-item-property-custom-value']";
    private final String sizeSelected = "//span[@data-ramka='ramka2']/following-sibling::li[2][contains(@class,\"basket-item-scu-item selected\")]";
    private final String sizeSecondSelected = "//span[@data-ramka='ramka2']/following-sibling::li[4][contains(@class,\"basket-item-scu-item selected\")]";
    private final String orderTotal = "//*[@id='basket-root']/div[1]/div/div/div[2]/div/div[2]/div/div";
    private final String deleteFromCart ="//span[@class='basket-item-actions-remove']";
    private final String checkCart="//td[contains(@class,'img_wrapp')]";
    private final String inputCoupon="//input[@id= 'coupon_input']";
    private final String buttonAddCoupon="//span[@class= 'basket-coupon-block-coupon-btn']";
    private final String changePrice="//div[@class='basket-coupon-block-total-price-current']";

    public CartPage(WebDriver driver){super(driver);}

    public String getSneakersArticle() {
        return waitForElementLocatedBy(driver, By.xpath(productArticle), WAIT_TIME_SECONDS).getText();
    }

    public String getSneakersSecondArticle() {
        return waitForElementLocatedBy(driver, By.xpath(productSecondArticle), WAIT_TIME_SECONDS).getText();
    }

    public String actualSizeSelected() {
        return waitForElementLocatedBy(driver, By.xpath(sizeSelected), WAIT_TIME_SECONDS).getText();

    }

    public String actualSizeSecondSelected() {
        return waitForElementLocatedBy(driver, By.xpath(sizeSecondSelected), WAIT_TIME_SECONDS).getText();

    }

    public double getCartOrderTotal() {
        return Double.parseDouble(waitForElementLocatedBy(driver, By.xpath(orderTotal), WAIT_TIME_SECONDS).getText().replace(" BYN", ""));
    }

    public CartPage deleteFromCart() {
        WebElement deleteButton = waitForElementLocatedBy(driver,
                By.xpath(deleteFromCart),WAIT_TIME_SECONDS);
        deleteButton.click();
        return this;
    }
    public boolean checkCart() {
        return waitForElementLocatedBy(driver,
                By.xpath(checkCart),WAIT_TIME_SECONDS).isDisplayed();
    }

    public CartPage inputCorrectPromocode(String Coupon){
        WebElement inputPromocode = waitForElementLocatedBy(driver,
                By.xpath(inputCoupon),
                WAIT_TIME_SECONDS);
        inputPromocode.sendKeys(Coupon);
        return this;
    }

    public CartPage buttonPromocode() {
        WebElement promocodeButton = waitForElementLocatedBy(driver,
                By.xpath(buttonAddCoupon),WAIT_TIME_SECONDS);
        promocodeButton.click();
        return this;
    }

    public CartPage searchChangePrice(){
        WebElement searchPrice = waitForElementLocatedBy(driver,
                By.xpath(changePrice),
                WAIT_TIME_SECONDS);
        searchPrice.getText();
        return this;
    }
}
