package test;

import model.User;
import org.testng.annotations.Test;
import page.AccountPage;
import page.LoginPage;
import service.UserCreator;
import sun.util.logging.resources.logging;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends CommonConditions {
    @Test
    public void userAccessTest(){
        User testUser = UserCreator.withAllProperty();
        LoginPage loginPage=new LoginPage(driver)
                .openPage()
                .inputUserLogin(testUser.getUserEmail())
                .inputUserPassword(testUser.getPassword());

        String currentUrl=loginPage.getCurrentUrl();
        loginPage.clickSubmitButton();

        assertThat(loginPage.getCurrentUrl()).isNotEqualTo(currentUrl);

        AccountPage accountPage = loginPage.clickGoToAccountPageButton();

        assertThat(accountPage.getUserName()).contains(testUser.getUsername());
        assertThat(accountPage.getUserNameEmail()).contains(testUser.getUserEmail());

    }

    @Test
    public void userAccessTestWithFaildEmail(){
        User testUser = UserCreator.withFaildEmailProperty();
        LoginPage loginPage=new LoginPage(driver)
                .openPage()
                .inputUserLogin(testUser.getUserEmail())
                .inputUserPassword(testUser.getPassword());

        String currentUrl=loginPage.getCurrentUrl();
        loginPage.clickSubmitButton();

        assertThat(loginPage.getCurrentUrl()).isNotEqualTo(currentUrl);
        assertThat(loginPage.cheackFaildEmailORPassword()).isTrue();

    }

    @Test
    public void userAccessTestWithFaildPassword(){
        User testUser = UserCreator.withFaildPasswordProperty();
        LoginPage loginPage=new LoginPage(driver)
                .openPage()
                .inputUserLogin(testUser.getUserEmail())
                .inputUserPassword(testUser.getPassword());

        String currentUrl=loginPage.getCurrentUrl();
        loginPage.clickSubmitButton();

        assertThat(loginPage.getCurrentUrl()).isNotEqualTo(currentUrl);
        assertThat(loginPage.cheackFaildEmailORPassword()).isTrue();

    }
}
