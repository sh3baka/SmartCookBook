package lv.shebaka.smartcookbook.Logic;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeData;

public class AddRecipeService {

    private RecipeData recipeData;

    public AddRecipeService(RecipeData recipeData) {
        this.recipeData = recipeData;
    }

    public void addRecipe(String title, String desc){

        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDesc(desc);
        recipeData.add(recipe);
    }
}
