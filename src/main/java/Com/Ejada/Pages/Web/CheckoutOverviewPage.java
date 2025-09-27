package Com.Ejada.Pages.Web;

import Com.Ejada.Core.Helpers.ActionHelper;
import Com.Ejada.Core.Helpers.VerifyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CheckoutOverviewPage {
    public CheckoutOverviewPage(WebDriver driver, ActionHelper action) {
        PageFactory.initElements(driver, this);
        this.action = action;
    }
    ActionHelper action;
    VerifyHelper verify = new VerifyHelper();

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement checkoutOverviewTitle;

    @FindBy(xpath = "//*[@id=\"item_5_title_link\"]/div")
    public WebElement productSelected;

    @FindBy(id = "finish")
    public WebElement finishBtn;

    public void setCompleteCheckout(SoftAssert softAssert, WebDriver driver)throws InterruptedException{
        action.waitForExistence(checkoutOverviewTitle, "checkoutOverviewTitle", driver);
        verify.verifyElementDisplayed(checkoutOverviewTitle, "Success Checkout Overview Title should be displayed", softAssert);
        verify.verifyElementDisplayed(productSelected, "Success product Selected should be displayed", softAssert);
        action.clickElement(finishBtn, "finishBtn", driver);
    }
}
