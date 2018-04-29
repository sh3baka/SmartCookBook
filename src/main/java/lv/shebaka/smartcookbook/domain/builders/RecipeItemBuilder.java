package lv.shebaka.smartcookbook.domain.builders;

import lv.shebaka.smartcookbook.domain.Product;
import lv.shebaka.smartcookbook.domain.Recipe;
import lv.shebaka.smartcookbook.domain.RecipeItem;

public class RecipeItemBuilder {

    private Long id;
    private Recipe recipes;
    private Product product;

    RecipeItemBuilder(){}

    public static RecipeItemBuilder createRecipeItem(){return new RecipeItemBuilder();}

    public RecipeItem build(){
        RecipeItem item = new RecipeItem();
        item.setId(id);
        item.setRecipes(recipes);
        item.setProduct(product);
        return item;
    }

    public RecipeItemBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public RecipeItemBuilder with(Recipe recipe){
        this.recipes = recipe;
        return this;
    }

    public RecipeItemBuilder with(RecipeBuilder recipeBuilder){
        this.recipes = recipeBuilder.build();
        return this;
    }

    public RecipeItemBuilder with(Product product){
        this.product = product;
        return this;
    }

    public RecipeItemBuilder with(ProductBuilder productBuilder){
        this.product = productBuilder.build();
        return this;
    }
}
