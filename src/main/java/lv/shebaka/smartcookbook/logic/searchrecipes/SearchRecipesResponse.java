package lv.shebaka.smartcookbook.logic.searchrecipes;

import lv.shebaka.smartcookbook.domain.Recipe;

import java.util.List;

public class SearchRecipesResponse {

    private List<Recipe> recipes;

    public SearchRecipesResponse(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "SearchRecipesResponse{" +
                "recipes=" + recipes +
                '}';
    }
}
