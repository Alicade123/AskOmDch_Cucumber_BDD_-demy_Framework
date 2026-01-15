package askomdch.step.definitions;

import askomdch.api.CartApi;
import askomdch.constants.EndPoints;
import askomdch.context.dependency_injection.TestContext;
import askomdch.domain.object.Product;
import askomdch.pages.PageFactoryManager;
import askomdch.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreStepDefinitions {
    private final StorePage storePage;
    private final TestContext testContext;

    public StoreStepDefinitions(TestContext testContext){
        this.testContext = testContext;
        storePage = PageFactoryManager.getStorePage(testContext.driver);
    }

    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
        storePage.load(EndPoints.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        storePage.addToCart(product.getProductName());
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
//        storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(testContext.cookies.getCookies());
        cartApi.addToCart(1215, 1);
        testContext.cookies.setCookies(cartApi.getCookies());
        testContext.cookies.injectCookiesToBrowser(testContext.driver);
    }
}
