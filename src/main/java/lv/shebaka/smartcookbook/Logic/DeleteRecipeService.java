package lv.shebaka.smartcookbook.Logic;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeData;

import java.util.Optional;

public class DeleteRecipeService {

    private RecipeData recipeData;

    public DeleteRecipeService(RecipeData recipeData){
        this.recipeData = recipeData;
    }

    public boolean deleteRecipe(String title){
        Optional<Recipe> foundRecipe = recipeData.findByTitle(title);
        if(foundRecipe.isPresent()){
            Recipe recipe = foundRecipe.get();
            recipeData.remove(recipe);
            return true;
        }else {
            return false;
        }

    }
}
