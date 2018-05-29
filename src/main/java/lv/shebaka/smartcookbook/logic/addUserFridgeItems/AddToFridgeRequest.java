package lv.shebaka.smartcookbook.logic.addUserFridgeItems;

import lv.shebaka.smartcookbook.domain.Product;
import lv.shebaka.smartcookbook.domain.User;

public class AddToFridgeRequest {

    private User user;
    private Product product;

    public AddToFridgeRequest(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
