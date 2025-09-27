package BookAPI;

import Com.Ejada.Core.Base.ApiTestBase.Post;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
public class TC003CancelOrder extends Post {
    @Test(description = "Cancel Order")
    public void CancelOrder() {
        Post.accessToken();
        Post.submitOrder();
        Post.deleteOrder();
    }
}
