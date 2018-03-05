package lv.shebaka.smartcookbook.data;

import lv.shebaka.smartcookbook.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeData {


    void add(Recipe recipe);

    Optional<Recipe> findByTitle(String title);

    void remove(Recipe recipe);

    List<Recipe> getAllRecipes();

}
