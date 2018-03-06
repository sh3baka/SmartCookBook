package lv.shebaka.smartcookbook.Logic;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeDatabase;

import java.util.Optional;

public class DeleteRecipeService {

    private RecipeDatabase recipeDatabase;

    public DeleteRecipeService(RecipeDatabase recipeDatabase){
        this.recipeDatabase = recipeDatabase;
    }

    public boolean deleteRecipe(String title){
        Optional<Recipe> foundRecipe = recipeDatabase.findByTitle(title);
        if(foundRecipe.isPresent()){
            Recipe recipe = foundRecipe.get();
            recipeDatabase.remove(recipe);
            return true;
        }else {
            return false;
        }

    }
}
