package lv.shebaka.smartcookbook.logic.addrecipe;

import lv.shebaka.smartcookbook.data.orm.RecipeDatabaseImpl;
import lv.shebaka.smartcookbook.domain.Recipe;
import lv.shebaka.smartcookbook.logic.AddResponse;
import lv.shebaka.smartcookbook.logic.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class AddRecipeService {

    @Autowired private RecipeDatabaseImpl recipeDatabaseImpl;
    @Autowired private AddRecipeValidator addRecipeValidator;

   @Transactional
    public AddResponse addRecipe(String title, String desc) {

        List<Error> validationErrors = addRecipeValidator.validate(title, desc);
        if (!validationErrors.isEmpty()) {
            return new AddResponse(false, validationErrors);
        }

        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDesc(desc);
        recipeDatabaseImpl.add(recipe);

        return new AddResponse(true, null);
    }
}
