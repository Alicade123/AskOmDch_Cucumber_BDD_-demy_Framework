package askomdch.step.definitions;


import askomdch.context.dependency_injection.TestContext;
import askomdch.domain.object.Product;
import askomdch.pages.CartPage;
import askomdch.pages.PageFactoryManager;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStepDefinitions {
    private final CartPage cartPage;

    public CartStepDefinitions(TestContext testContext){
        cartPage = PageFactoryManager.getCartPage(testContext.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        Assert.assertEquals(product.getProductName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}
