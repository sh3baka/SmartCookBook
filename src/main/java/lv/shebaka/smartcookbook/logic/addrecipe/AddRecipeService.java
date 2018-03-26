package lv.shebaka.smartcookbook.logic.addrecipe;

import lv.shebaka.smartcookbook.data.RecipeRealDatabase;
import lv.shebaka.smartcookbook.domain.Recipe;
import lv.shebaka.smartcookbook.logic.AddResponse;
import lv.shebaka.smartcookbook.logic.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AddRecipeService {

    @Autowired private RecipeRealDatabase realDatabase;
    @Autowired private AddRecipeValidator addRecipeValidator;

    public AddRecipeService(RecipeRealDatabase recipeRealDatabase, AddRecipeValidator addRecipeValidator) {
        this.realDatabase = recipeRealDatabase;
        this.addRecipeValidator = addRecipeValidator;
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
