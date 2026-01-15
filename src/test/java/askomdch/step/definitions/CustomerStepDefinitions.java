package askomdch.step.definitions;

import askomdch.constants.MyConstants;
import askomdch.context.dependency_injection.TestContext;
import askomdch.domain.object.BillingDetails;
import askomdch.pages.PageFactoryManager;
import askomdch.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CustomerStepDefinitions {
    private final TestContext testContext;
    private final StorePage storePage;

    public CustomerStepDefinitions(TestContext testContext){
        this.testContext = testContext;
        storePage = PageFactoryManager.getStorePage(testContext.driver);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        testContext.billingDetails = billingDetails;
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        storePage.load(MyConstants.STORE);
    }
}
