package askomdch.domain.object;

public class Product {
    public Product(String productName) {
        setProductName(productName);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String productName;
}
