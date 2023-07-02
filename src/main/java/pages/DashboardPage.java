package pages;

import core.BasePage;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.WaitTool;
import org.apache.commons.lang3.RandomStringUtils;


import java.util.random.RandomGenerator;

import static utils.Browser.driver;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//img[@id='user-profile']/ ..")
    private static WebElement usernameLink;

    @FindBy(xpath = "//*[@id='menu-customer']/a")
    private static WebElement customersLabel;

    @FindBy(xpath ="//li[@id='menu-catalog']/*[1]")
    private static WebElement catalogLabel;

    @FindBy(xpath = "//*[@class='collapse in']/li[1]/a")
    private static WebElement categoriesLabel;

    @FindBy(xpath = "//*[@class='collapse in']/li[2]/a")
    private static WebElement productsLabel;

    @FindBy(xpath = "//*[@class='pull-right']/*[1]")
    private static WebElement addNewCategoryButton;

    @FindBy(id = "input-name1")
    private static WebElement inputNewCategoryField;

    @FindBy(xpath = "//*[@id='content']/div[1]//button")
    private static WebElement saveAddNewCategoryButton;

    @FindBy(css = ".alert-success")
    private static WebElement allertMessageLabel;


    static {
        PageFactory.initElements(driver,DashboardPage.class);
    }

    public static void verifyUsernameLabelText(String expectedText) {
        WaitTool.waitForElementVisibility(By.xpath("//img[@id='user-profile']/ .."),3);
        Assert.assertEquals(usernameLink.getText(), expectedText);
    }

    public static void clickOnCustomerLabel(){
        clickOnElement(customersLabel);
    }

    public static void clickOnCatalogLabel(){
        WaitTool.waitForElementVisibility(By.xpath("//li[@id='menu-catalog']/*[1]"),3);
        clickOnElement(catalogLabel);
    }

    public static void clickOnCategoriesLabel(){
        WaitTool.waitForElementVisibility(By.xpath("//*[@class='collapse in']/li[1]/a"),10);
        clickOnElement(categoriesLabel);
    }

    public static void clickOnProductsLabel(){
        clickOnElement(productsLabel);
    }

    public static void clickOnAddNewProductCategory(){
        WaitTool.waitForElementVisibility(By.xpath("//*[@class='pull-right']/*[1]"), 3);
        clickOnElement(addNewCategoryButton);
    }

    public static String newProductCategoryName = RandomStringUtils.randomAlphabetic(3);
    public static void writeTextInInputNewCategoryNameField(){
        WaitTool.waitForElementVisibility(By.id("input-name1"),3);
        driver.findElement(By.id("input-name1")).sendKeys(newProductCategoryName);

    }

    public static String metaTagTitleText = RandomStringUtils.randomAlphabetic(3);
    public static void writeTextInMetaTagTitleField(){
        WaitTool.waitForElementVisibility(By.id("input-meta-title1"),3);
        driver.findElement(By.id("input-meta-title1")).sendKeys(metaTagTitleText);
    }

    public static void clickSaveNewCategoryButton(){
        clickOnElement(saveAddNewCategoryButton);
    }

    public static void verifyValidationMessage(String expectedValidationMessage) {
        WaitTool.waitForElementVisibility(By.cssSelector(".alert-success"),3);
        String actualValidationMessage = driver.findElement(By.cssSelector(".alert-success")).getText();
        Assert.assertTrue(actualValidationMessage.contains(expectedValidationMessage));
    }


}
