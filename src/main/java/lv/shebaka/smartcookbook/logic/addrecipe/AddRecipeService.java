package lv.shebaka.smartcookbook.logic.addrecipe;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeDatabase;
import lv.shebaka.smartcookbook.data.recipeRealDatabase;
import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public class AddRecipeService {

    //private RecipeDatabase database;
    private recipeRealDatabase realDatabase;
    private AddRecipeValidator addRecipeValidator;

    public AddRecipeService(recipeRealDatabase realDatabase, AddRecipeValidator addRecipeValidator) {

        //this.database = database;
        this.addRecipeValidator = addRecipeValidator;
        this.realDatabase = realDatabase;
    }

    public AddRecipeResponse addRecipe(String title, String desc) {

        List<Error> validationErrors = addRecipeValidator.validate(title, desc);
        if (!validationErrors.isEmpty()) {
            return new AddRecipeResponse(false, validationErrors);
        }

        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDesc(desc);
        realDatabase.add(recipe);
        //database.add(recipe);

        return new AddRecipeResponse(true, null);
    }
}
