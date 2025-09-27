package Com.Ejada.Pages.Web;

import Com.Ejada.Core.Helpers.ActionHelper;
import Com.Ejada.Core.Helpers.VerifyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CartPage {
    public CartPage(WebDriver driver, ActionHelper action) {
        PageFactory.initElements(driver, this);
        this.action = action;
    }
    ActionHelper action;
    VerifyHelper verify = new VerifyHelper();

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement cartTitle;

    @FindBy(xpath = "//*[@id=\"item_5_title_link\"]/div")
    public WebElement jacketDisplayed;

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;


    public void setCheckoutJacket(SoftAssert softAssert, WebDriver driver)throws InterruptedException{
        action.waitForExistence(cartTitle, "cart Title", driver);
        verify.verifyElementDisplayed(cartTitle, "Success cart Title should be displayed", softAssert);
        verify.verifyElementDisplayed(jacketDisplayed, "Success jacket should be displayed", softAssert);
        action.clickElement(checkoutBtn, "checkoutBtn", driver);
    }
}
