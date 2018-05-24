package lv.shebaka.smartcookbook.data;

import lv.shebaka.smartcookbook.domain.Product;
import lv.shebaka.smartcookbook.domain.Recipe;
import lv.shebaka.smartcookbook.domain.RecipeItem;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {


    void add(Recipe recipe);

    Optional<Recipe> findByTitle(String title);

    void remove(Recipe recipe);

    List<Recipe> getAllRecipes();

    List<RecipeItem> getRecipeProducts(Recipe recipe);

}
