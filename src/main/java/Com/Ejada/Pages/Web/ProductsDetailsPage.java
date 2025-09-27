package Com.Ejada.Pages.Web;

import Com.Ejada.Core.Helpers.ActionHelper;
import Com.Ejada.Core.Helpers.VerifyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ProductsDetailsPage {
    public ProductsDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    ActionHelper action = new ActionHelper();
    VerifyHelper verify = new VerifyHelper();

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    public WebElement jacketDetailsOpened;

    @FindBy(id = "add-to-cart")
    public WebElement addToCartBtn;

    @FindBy(id = "remove")
    public WebElement removeBtn;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    public WebElement cartIcon;

    public void setJacketDetails(SoftAssert softAssert, WebDriver driver)throws InterruptedException{
        action.waitForExistence(jacketDetailsOpened, "jacketDetailsOpened", driver);
        verify.verifyElementDisplayed(jacketDetailsOpened, "Success jacket Details should be displayed", softAssert);
        action.clickElement(addToCartBtn, "add To Cart Btn", driver);
        verify.verifyElementDisplayed(removeBtn, "Success remove Btn should be displayed", softAssert);
        action.clickElement(cartIcon, " Cart Btn", driver);
    }
}
