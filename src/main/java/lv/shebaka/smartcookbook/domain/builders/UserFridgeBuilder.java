package lv.shebaka.smartcookbook.domain.builders;

import lv.shebaka.smartcookbook.domain.Product;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.domain.UserFridge;

public class UserFridgeBuilder {

    private Long id;
    private User user;
    private Product product;

    private UserFridgeBuilder(){}

    public static UserFridgeBuilder createUserFridge(){
        return new UserFridgeBuilder();
    }

    public UserFridge build(){
        UserFridge userFridge = new UserFridge();
        userFridge.setId(id);
        userFridge.setUser(user);
        userFridge.setProduct(product);
        return userFridge;
    }

    public UserFridgeBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public UserFridgeBuilder withUser(User user){
        this.user = user;
        return this;
    }

    public UserFridgeBuilder withUser(UserBuilder userBuilder){
        this.user = userBuilder.build();
        return this;
    }

    public UserFridgeBuilder withProduct(Product product){
        this.product = product;
        return this;
    }

    public UserFridgeBuilder withProduct(ProductBuilder productBuilder){
        this.product = productBuilder.build();
        return this;
    }
}
