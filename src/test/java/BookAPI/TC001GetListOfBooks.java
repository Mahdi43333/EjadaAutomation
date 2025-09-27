package BookAPI;

import Com.Ejada.Core.Base.ApiTestBase.Get;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
public class TC001GetListOfBooks extends Get {
    @Test(description = "Get List Of Books")
    @Description("This test case validates successful checkout flow for a jacket purchase")

    public void GetListOfBooks(){
        Get.listOfBooks();
    }
}
