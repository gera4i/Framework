package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='USER_LOGIN_POPUP']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='USER_PASSWORD_POPUP']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@class='btn btn-default bold']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//i[@class='personal']")
    private WebElement accountPageButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement faildEmailOrPassword;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public LoginPage openPage()
    {
        driver.navigate().to("https://secure1.store.apple.com/ru/shop/signIn");
        return this;
    }

    public LoginPage inputUserLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage inputUserPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButton(){
        buttonSubmit.click();
        return this;
    }

    public AccountPage clickGoToAccountPageButton(){
        accountPageButton.click();
        return new AccountPage(driver);
    }

    public boolean cheackFaildEmailORPassword(){
        return  faildEmailOrPassword.isDisplayed();
    }
}
