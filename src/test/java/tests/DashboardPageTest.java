package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardPageTest extends BaseTest {

    @Test
    public void addNewProductCategory(){
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin");
        LoginPage.writeTextinPasswordInputField("parola123!");
        LoginPage.clickLoginButton();
        DashboardPage.clickOnCatalogLabel();
        DashboardPage.clickOnCategoriesLabel();
        DashboardPage.clickOnAddNewProductCategory();
        DashboardPage.writeTextInInputNewCategoryNameField();
        DashboardPage.writeTextInMetaTagTitleField();
        DashboardPage.clickSaveNewCategoryButton();
        DashboardPage.verifyValidationMessage("Success: You have modified categories!");


    }
}
