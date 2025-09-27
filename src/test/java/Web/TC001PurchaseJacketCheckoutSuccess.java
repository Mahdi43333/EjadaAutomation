package Web;

import Com.Ejada.Core.Helpers.ActionHelper;
import Com.Ejada.Core.Helpers.DataHelper;
import Com.Ejada.Pages.Web.*;
import Com.Ejada.Core.Base.WebTestBase.TestBrowsers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({AllureTestNg.class})
public class TC001PurchaseJacketCheckoutSuccess extends TestBrowsers {
    ActionHelper action = new ActionHelper();
    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Purchase Jacket Checkout Success")
    @Description("This test case validates successful checkout flow for a jacket purchase")

    public void PurchaseJacketCheckoutSuccess() throws InterruptedException {
        login();
        selectJacket();
        viewJacketDetails();
        checkoutJacket();
        enterCheckoutInformation();
        completeCheckout();
        backToProductsPage();
    }
    @Given("I am logged in with valid credentials")
    @Step("Login with valid credentials")
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, action);
        loginPage.loginWithValidCredentials(DataHelper.userName, DataHelper.password, driver);
    }
    @When("I select a jacket from the products page")
    @Step("Select jacket from products page")
    public void selectJacket() throws InterruptedException {
        ProductsPage jacket = new ProductsPage(driver, action);
        jacket.setSelectJacket(softAssert, driver);
    }
    @And("I view the jacket details")
    @Step("View jacket details")
    public void viewJacketDetails() throws InterruptedException {
        ProductsDetailsPage jacketDetails = new ProductsDetailsPage(driver);
        jacketDetails.setJacketDetails(softAssert, driver);
    }
    @And("I add the jacket to the cart and go to checkout")
    @Step("Add jacket to cart and go to checkout")
    public void checkoutJacket() throws InterruptedException {
        CartPage checkoutJacket = new CartPage(driver, action);
        checkoutJacket.setCheckoutJacket(softAssert, driver);
    }
    @And("I enter checkout information")
    @Step("Enter checkout information")
    public void enterCheckoutInformation() throws InterruptedException {
        CheckoutInformationPage info = new CheckoutInformationPage(driver, action);
        info.setCheckoutInformation(softAssert, driver);
    }
    @And("I complete the checkout overview")
    @Step("Complete checkout overview")
    public void completeCheckout() throws InterruptedException {
        CheckoutOverviewPage complete = new CheckoutOverviewPage(driver, action);
        complete.setCompleteCheckout(softAssert, driver);
    }
    @Then("I return to the products page after checkout is complete")
    @Step("Return to products page after checkout complete")
    public void backToProductsPage() throws InterruptedException {
        CheckoutCompletePage backToProductsPage = new CheckoutCompletePage(driver, action);
        backToProductsPage.setBackToProductsPage(softAssert, driver);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
    }
}