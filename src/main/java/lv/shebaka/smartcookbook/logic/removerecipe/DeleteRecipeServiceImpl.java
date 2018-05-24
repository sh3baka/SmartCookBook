package lv.shebaka.smartcookbook.logic.removerecipe;

import lv.shebaka.smartcookbook.data.RecipeRepository;
import lv.shebaka.smartcookbook.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class DeleteRecipeServiceImpl implements DeleteRecipeService{

    @Autowired
    private RecipeRepository recipeRepository;
    //@Autowired private RecipeRealDatabase realDatabase;
    @Transactional
    public boolean deleteRecipe(String title) {
        Optional<Recipe> foundRecipe = recipeRepository.findByTitle(title);
        if (foundRecipe.isPresent()) {
            Recipe recipe = foundRecipe.get();
            recipeRepository.remove(recipe);
            return true;
        } else {
            return false;
        }

    }
}
