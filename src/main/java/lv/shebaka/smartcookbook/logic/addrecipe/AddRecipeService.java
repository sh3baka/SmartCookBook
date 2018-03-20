package lv.shebaka.smartcookbook.logic.addrecipe;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeRealDatabase;
import lv.shebaka.smartcookbook.logic.AddResponse;
import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public class AddRecipeService {

    private RecipeRealDatabase realDatabase;
    private AddRecipeValidator addRecipeValidator;

    public AddRecipeService(RecipeRealDatabase realDatabase, AddRecipeValidator addRecipeValidator) {

        this.addRecipeValidator = addRecipeValidator;
        this.realDatabase = realDatabase;
    }

    public AddResponse addRecipe(String title, String desc) {

        List<Error> validationErrors = addRecipeValidator.validate(title, desc);
        if (!validationErrors.isEmpty()) {
            return new AddResponse(false, validationErrors);
        }

        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDesc(desc);
        realDatabase.add(recipe);

        return new AddResponse(true, null);
    }
}
