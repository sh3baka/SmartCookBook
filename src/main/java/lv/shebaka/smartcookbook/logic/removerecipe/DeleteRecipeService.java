package lv.shebaka.smartcookbook.logic.removerecipe;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeDatabase;
import lv.shebaka.smartcookbook.data.recipeRealDatabase;

import java.util.Optional;

public class DeleteRecipeService {

   //private RecipeDatabase recipeDatabase;
    private recipeRealDatabase realDatabase;

    public DeleteRecipeService(recipeRealDatabase realDatabase){
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
