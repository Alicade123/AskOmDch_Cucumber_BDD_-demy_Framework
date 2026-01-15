package askomdch.constants;

public enum EndPoints {
    STORE("/store"),
    ACCOUNT("/account"),
    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    CHECKOUT("/checkout");
    public final String url ;
    EndPoints(String endpoint) {
        this.url = endpoint;
    }
}
