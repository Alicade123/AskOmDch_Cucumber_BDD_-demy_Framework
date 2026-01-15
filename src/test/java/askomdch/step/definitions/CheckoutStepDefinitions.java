package askomdch.step.definitions;

import askomdch.constants.EndPoints;
import askomdch.context.dependency_injection.TestContext;
import askomdch.pages.CheckoutPage;
import askomdch.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutStepDefinitions {
    private final TestContext testContext;
    private final CheckoutPage checkoutPage;

    public CheckoutStepDefinitions(TestContext testContext){
        this.testContext = testContext;
        checkoutPage = PageFactoryManager.getCheckoutPage(testContext.driver);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkoutPage.setBillingDetails(testContext.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getStatusMessage());
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.load(EndPoints.CHECKOUT.url);
    }
}
