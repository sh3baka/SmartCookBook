package lv.shebaka.smartcookbook.logic.removerecipe;

import lv.shebaka.smartcookbook.data.RecipeRealDatabase;
import lv.shebaka.smartcookbook.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class DeleteRecipeService {

    @Autowired private RecipeRealDatabase realDatabase;

    public boolean deleteRecipe(String title){
        Optional<Recipe> foundRecipe = realDatabase.findByTitle(title);
        if(foundRecipe.isPresent()){
            Recipe recipe = foundRecipe.get();
            realDatabase.remove(recipe);
            return true;
        }else {
            return false;
        }

    }
}
