package askomdch.step.definitions;
import askomdch.domain.object.BillingDetails;
import askomdch.domain.object.Product;
import askomdch.factory.DriverFactory;
import askomdch.pages.CartPage;
import askomdch.pages.CheckoutPage;
import askomdch.pages.StorePage;
import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart {
    private WebDriver driver;
    private String websiteUrl = "https://askomdch.com/store";
    private BillingDetails billingDetails;

    @Given("I'm on the Store Page of AskOmDch")
    public void goToStorePageOfAskOmDch() {
        driver = DriverFactory.initializeDriver();
        new StorePage(driver).load(websiteUrl);
    }

    @When("I add a {product} in the cart")
    public void addProductToCart(Product product) {
        new StorePage(driver).addToCart(product.getProductName());
    }

    @Then("I'm should see {int} {product} in the cart.")
    public void checkCart(int productQuantity, Product product) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(product.getProductName(), cartPage.getProductName()) ;
        Assert.assertEquals(productQuantity, cartPage.getProductQuantity());

    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() {
        driver = DriverFactory.initializeDriver();
        new StorePage(driver).load(websiteUrl);
    }

    @And("my billing details are")
    public void setBillingDetails(BillingDetails billingDetails){
    this.billingDetails = billingDetails;
    }
    @Given("I'm have a product in the cart")
    public void i_m_have_a_product_in_the_cart() {
        new StorePage(driver).addToCart("Blue Shoes");
    }
    @Given("I'm on the Checkout Page")
    public void i_m_on_the_checkout_page() {
        By checkoutBtn = By.cssSelector(".checkout-button");
        driver.findElement(checkoutBtn).click();
    }
    @When("I'm provide billing details")
    public void i_m_provide_billing_details() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(billingDetails);
    }
    @When("I place an Order")
    public void i_place_an_order() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        String expectedResult = "Thank you. Your order has been received.";
        Assert.assertEquals(expectedResult,new CheckoutPage(driver).getStatusMessage());
    }
}