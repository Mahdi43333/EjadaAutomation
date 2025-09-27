package BookAPI;

import Com.Ejada.Core.Base.ApiTestBase.Post;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({AllureTestNg.class})
public class TC002PlaceOrderForNewBook extends Post {
    @Test(description = "Place Order For a New Book")
    public void PlaceOrderForNewBook() {
        Post.accessToken();
        Post.submitOrder();
    }
}
