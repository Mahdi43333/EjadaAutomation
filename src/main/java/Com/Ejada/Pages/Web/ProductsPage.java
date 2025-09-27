package Com.Ejada.Pages.Web;

import Com.Ejada.Core.Helpers.ActionHelper;
import Com.Ejada.Core.Helpers.VerifyHelper;
import Com.Ejada.Core.Helpers.ActionHelper;
import Com.Ejada.Core.Helpers.VerifyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ProductsPage {
    public ProductsPage(WebDriver driver, ActionHelper action) {
        PageFactory.initElements(driver, this);
        this.action = action;
    }
    ActionHelper action;
    VerifyHelper verify = new VerifyHelper();

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement productsTitle;
    @FindBy(xpath = "//*[@id=\"item_5_title_link\"]")
    public WebElement openJacketDetails;


    public void setSelectJacket(SoftAssert softAssert, WebDriver driver)throws InterruptedException{
        action.waitForExistence(productsTitle, "products Title", driver);
        verify.verifyElementDisplayed(productsTitle, "Success productsTitle should be displayed", softAssert);
        action.clickElement(openJacketDetails, "open Jacket Details", driver);
    }
}
