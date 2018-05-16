package lv.shebaka.smartcookbook.logic.removerecipe;

import lv.shebaka.smartcookbook.data.RecipeDatabase;
import lv.shebaka.smartcookbook.data.orm.RecipeDatabaseImpl;
import lv.shebaka.smartcookbook.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class DeleteRecipeServiceImpl implements DeleteRecipeService{

    @Autowired
    private RecipeDatabase recipeDatabase;
    //@Autowired private RecipeRealDatabase realDatabase;
    @Transactional
    public boolean deleteRecipe(String title) {
        Optional<Recipe> foundRecipe = recipeDatabase.findByTitle(title);
        if (foundRecipe.isPresent()) {
            Recipe recipe = foundRecipe.get();
            recipeDatabase.remove(recipe);
            return true;
        } else {
            return false;
        }

    }
}
