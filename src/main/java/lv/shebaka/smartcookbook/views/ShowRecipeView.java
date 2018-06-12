package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.data.UserRepository;
import lv.shebaka.smartcookbook.domain.Recipe;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.searchRecipes.SearchRecipesRequest;
import lv.shebaka.smartcookbook.logic.searchRecipes.SearchRecipesResponse;
import lv.shebaka.smartcookbook.logic.searchRecipes.SearchRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ShowRecipeView implements View {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    SearchRecipesService searchRecipesService;

    @Override
    public void execute() {

        Optional<User> foundUser = userRepository.findByUsername("Test");
//       if (foundUser.isPresent()){
//           User user = foundUser.get();
//           for(UserFridge userFridge : userRepository.getUserProductsByUsername(user)){
//               System.out.println(userFridge.getUser().getUsername() + "[" + userFridge.getProduct().getId() + "]");
//           }
//       }

        if (foundUser.isPresent()) {

            User user = foundUser.get();

            SearchRecipesResponse searchRecipesResponse = searchRecipesService.searchRecipes(new SearchRecipesRequest(user));

            List<Recipe> list = searchRecipesResponse.getRecipes();

            for (Recipe recipe : list) {
                System.out.println(recipe.getTitle());
            }
        }

        System.out.println();
        System.out.println("Выводим все рецепты в списке");

        System.out.println("Все рецепты выведены");
        System.out.println();

    }
}

