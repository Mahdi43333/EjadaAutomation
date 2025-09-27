package Com.Ejada.Pages.Web;

import Com.Ejada.Core.Helpers.ActionHelper;
import Com.Ejada.Core.Helpers.VerifyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CheckoutInformationPage {
    public CheckoutInformationPage(WebDriver driver, ActionHelper action) {
        PageFactory.initElements(driver, this);
        this.action = action;
    }
    ActionHelper action;
    VerifyHelper verify = new VerifyHelper();

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement CheckoutInformationTitle;

    @FindBy(name = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(name = "postalCode")
    public WebElement postalCodeField;

    @FindBy(id = "continue")
    public WebElement continueBtn;


    public void setCheckoutInformation(SoftAssert softAssert, WebDriver driver)throws InterruptedException{
        action.waitForExistence(CheckoutInformationTitle, "CheckoutInformationTitle", driver);
        verify.verifyElementDisplayed(CheckoutInformationTitle, "Success Checkout Information Title should be displayed", softAssert);
        action.setText(firstNameField, "Mahdi", "first Name Field", driver);
        action.setText(lastNameField, "Flaifl", "last Name Field", driver);
        action.setText(postalCodeField, "12354", "postal Code Field", driver);
        action.clickElement(continueBtn, "continueBtn", driver);
    }
}
