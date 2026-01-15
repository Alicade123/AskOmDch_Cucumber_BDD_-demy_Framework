package askomdch.domain.object;

public class BillingDetails {
    private String billingFirstName;

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingStateName() {
        return billingStateName;
    }

    public void setBillingStateName(String billingStateName) {
        this.billingStateName = billingStateName;
    }

    public String getBillingZipCode() {
        return billingZipCode;
    }

    public void setBillingZipCode(String billingZipCode) {
        this.billingZipCode = billingZipCode;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    private String billingLastName;

    public BillingDetails(String billingFirstName, String billingLastName, String billingCountry,
                          String billingAddress1,String billingCity, String billingStateName,
                          String billingZipCode, String billingEmail) {
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
        this.billingCountry = billingCountry;
        this.billingAddress1 = billingAddress1;
        this.billingCity = billingCity;
        this.billingStateName = billingStateName;
        this.billingZipCode = billingZipCode;
        this.billingEmail = billingEmail;
    }

    private String billingCountry;
    private String billingAddress1;
    private String billingCity;
    private String billingStateName;
    private String billingZipCode;
    private String billingEmail;
}
