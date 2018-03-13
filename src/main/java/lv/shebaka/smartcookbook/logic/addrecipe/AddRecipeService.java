package lv.shebaka.smartcookbook.logic.addrecipe;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeDatabase;
import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public class AddRecipeService {

    private RecipeDatabase database;
    private AddRecipeValidator addRecipeValidator;

    public AddRecipeService(RecipeDatabase database, AddRecipeValidator addRecipeValidator) {

        this.database = database;
        this.addRecipeValidator = addRecipeValidator;
    }

    public AddRecipeResponse addRecipe(String title, String desc) {

        List<Error> validationErrors = addRecipeValidator.validate(title, desc);
        if (!validationErrors.isEmpty()) {
            return new AddRecipeResponse(false, validationErrors);
        }

        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDesc(desc);
        database.add(recipe);

        return new AddRecipeResponse(true, null);
    }
}
