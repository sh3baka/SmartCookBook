package lv.shebaka.smartcookbook.logic.searchRecipes;

import lv.shebaka.smartcookbook.data.RecipeRepository;
import lv.shebaka.smartcookbook.data.UserRepository;
import lv.shebaka.smartcookbook.domain.Product;
import lv.shebaka.smartcookbook.domain.Recipe;
import lv.shebaka.smartcookbook.domain.RecipeItem;
import lv.shebaka.smartcookbook.domain.UserFridge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchRecipesServiceImpl implements SearchRecipesService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public SearchRecipesResponse searchRecipes(SearchRecipesRequest searchRequest) {

        List<Product> recipeProduct = new ArrayList<>();
        List<Product> userProduct = new ArrayList<>();
        List<Recipe> recipesToSearch = recipeRepository.getAllRecipes();
        List<Recipe> recipesToShow = new ArrayList<>();

        for (UserFridge userFridge : userRepository.getUserProductsByUsername(searchRequest.getUser())) {
            userProduct.add(userFridge.getProduct());
        }

        for (Recipe recipe : recipesToSearch) {
            for (RecipeItem recipeItem : recipeRepository.getRecipeProducts(recipe)) {
                recipeProduct.add(recipeItem.getProduct());
            }
            if (userProduct.containsAll(recipeProduct)) {
                recipesToShow.add(recipe);
                recipeProduct.clear();
            } else {
                recipeProduct.clear();
                continue;
            }
        }


        return new SearchRecipesResponse(recipesToShow);
    }
}
