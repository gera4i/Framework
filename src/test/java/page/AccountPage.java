package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='NAME']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='EMAIL']")
    private WebElement userNameEmail;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public AccountPage openPage() {
        driver.get("https://apple.ru/home");
        return this;
    }

    public String getUserName(){
        return userNameField.getAttribute("value");
    }

    public String getUserNameEmail(){
        return userNameEmail.getAttribute("value");
    }

}
