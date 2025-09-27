package Com.Ejada.Core.Helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class VerifyHelper {
    public void verifyElementDisplayed(WebElement element, String message, SoftAssert softAssert) {
        try {
            if (element != null && element.isDisplayed()) {
                Assert.assertTrue(true, message);
            } else {
                Assert.fail(message + " - Element not displayed");
            }
        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            Assert.fail(message + " - Element not found");
        } catch (Exception e) {
            Assert.fail(message + " - Unexpected error: " + e.getMessage());
        }
    }
}
