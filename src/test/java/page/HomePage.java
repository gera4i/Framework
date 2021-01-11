package page;

import org.openqa.selenium.WebDriver;


public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver){super(driver);}

    public HomePage openPage(){
        driver.get(HOME_URL);
        return this;
    }
}
