package askomdch.pages;

import askomdch.domain.object.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "billing_first_name") private WebElement billingFirstNameFld ;
    @FindBy(id = "billing_last_name") private WebElement billingLastNameFld ;
    @FindBy(id = "billing_country") private WebElement billingCountryFld ;
    @FindBy(id = "billing_address_1") private WebElement billingAddressOneNameFld ;
    @FindBy(id = "billing_city") private WebElement billingCityNameFld ;
    @FindBy(id = "billing_state") private WebElement billingStateNameFld ;
    @FindBy(id = "billing_postcode") private WebElement billingPostCodeNameFld;
    @FindBy(id = "billing_email") private WebElement billingEmailFld ;
    @FindBy(id = "place_order") private WebElement placeOrderButton;
    @FindBy(css = ".woocommerce-order p") private WebElement statusMessageField;

    public CheckoutPage enterBillingFirstName(String billingFirstName){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
        element.clear();
        element.sendKeys(billingFirstName);
        return this;
    }
    public CheckoutPage enterBillingLastName(String billingLastName){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        element.clear();
        element.sendKeys(billingLastName);
        return this;
    }
    public CheckoutPage enterBillingCountry(String billingCountry){
        new Select(billingCountryFld).selectByValue(billingCountry);
        return this;
    }
    public CheckoutPage enterBillingAddressOne(String billingAddressOne){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(billingAddressOneNameFld));
        element.clear();
        element.sendKeys(billingAddressOne);
        return this;
    }
    public CheckoutPage enterBillingCityName(String billingCityName){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(billingCityNameFld));
        element.clear();
        element.sendKeys(billingCityName);
        return this;
    }
    public CheckoutPage enterBillingState(String billingState){
        new Select(billingStateNameFld).selectByValue(billingState);
        return this;
    }

    public CheckoutPage enterBillingPostCode(String billingPostCode){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(billingPostCodeNameFld));
        element.clear();
        element.sendKeys(billingPostCode);
        return this;
    }
    public CheckoutPage enterBillingEmail(String billingEmail){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        element.clear();
        element.sendKeys(billingEmail);
        return this;
    }
    public CheckoutPage setBillingDetails(BillingDetails billingDetails){
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).
                enterBillingCountry(billingDetails.getBillingCountry()).
                enterBillingAddressOne(billingDetails.getBillingAddress1()).
                enterBillingCityName(billingDetails.getBillingCity()).
                enterBillingState(billingDetails.getBillingStateName()).
                enterBillingPostCode(billingDetails.getBillingZipCode()).
                enterBillingEmail(billingDetails.getBillingEmail());
    }
    public CheckoutPage placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
        return this;
    }
    public String getStatusMessage(){
       return wait.until(ExpectedConditions.visibilityOf(statusMessageField)).getText();
    }
}

