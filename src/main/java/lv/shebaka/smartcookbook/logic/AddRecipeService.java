package lv.shebaka.smartcookbook.logic;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeDatabase;

public class AddRecipeService {

    private RecipeDatabase database;

    public AddRecipeService(RecipeDatabase database) {

        this.database = database;
    }

    public void addRecipe(String title, String desc) {

        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDesc(desc);
        database.add(recipe);
    }
}
