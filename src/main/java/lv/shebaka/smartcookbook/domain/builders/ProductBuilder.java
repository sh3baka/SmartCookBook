package lv.shebaka.smartcookbook.domain.builders;

import lv.shebaka.smartcookbook.domain.Product;

public class ProductBuilder {
    private Long id;
    private String title;

    private ProductBuilder(){}

    public static ProductBuilder createProduckt(){
        return new ProductBuilder();
    }

    public Product build(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        return product;
    }

    public ProductBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public  ProductBuilder withTitle(String title){
        this.title = title;
        return this;
    }
}
