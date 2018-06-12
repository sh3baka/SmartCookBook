package lv.shebaka.smartcookbook.domain.builders;

import lv.shebaka.smartcookbook.domain.Recipe;

public class RecipeBuilder {

    private Long id;
    private String title;
    private String desc;

    RecipeBuilder() {
    }

    public static RecipeBuilder createRecipe() {
        return new RecipeBuilder();
    }

    public Recipe build() {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setTitle(title);
        recipe.setDesc(desc);
        return recipe;
    }

    public RecipeBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public RecipeBuilder wihtTitle(String title) {
        this.title = title;
        return this;
    }

    public RecipeBuilder withDescription(String desc) {
        this.desc = desc;
        return this;
    }

}
