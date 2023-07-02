package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginWithCorrectCredentials(){
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin");
        LoginPage.writeTextinPasswordInputField("parola123!");
        LoginPage.clickLoginButton();
        DashboardPage.verifyUsernameLabelText("Milen Strahinski");

    }


}
