package lv.shebaka.smartcookbook.logic.removerecipe;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeRealDatabase;

import java.util.Optional;

public class DeleteRecipeService {

    private RecipeRealDatabase realDatabase;

    public DeleteRecipeService(RecipeRealDatabase realDatabase){
        this.realDatabase = realDatabase;
    }

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
