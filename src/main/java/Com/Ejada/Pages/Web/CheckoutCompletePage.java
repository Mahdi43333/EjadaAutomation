package Com.Ejada.Pages.Web;

import Com.Ejada.Core.Helpers.ActionHelper;
import Com.Ejada.Core.Helpers.VerifyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CheckoutCompletePage {
    public CheckoutCompletePage(WebDriver driver, ActionHelper action) {
        PageFactory.initElements(driver, this);
        this.action = action;
    }
    ActionHelper action;
    VerifyHelper verify = new VerifyHelper();

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    public WebElement successMessage;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsBtn;


    public void setBackToProductsPage(SoftAssert softAssert, WebDriver driver)throws InterruptedException{
        action.waitForExistence(successMessage, "successMessage", driver);
        verify.verifyElementDisplayed(successMessage, "Success message should be displayed", softAssert);
        action.clickElement(backToProductsBtn, "backToProductsBtn", driver);
    }
}
