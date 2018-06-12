package lv.shebaka.smartcookbook.servlets.mvc;

import lv.shebaka.smartcookbook.domain.Recipe;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.searchRecipes.SearchRecipesRequest;
import lv.shebaka.smartcookbook.logic.searchRecipes.SearchRecipesResponse;
import lv.shebaka.smartcookbook.logic.searchRecipes.SearchRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class RecipesController {

    @Autowired
    private SearchRecipesService searchRecipesService;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ModelAndView getRecipes(@SessionAttribute("userModel") User user, HttpServletRequest request) {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        SearchRecipesResponse recipesResponse = searchRecipesService.
                searchRecipes(new SearchRecipesRequest(user));

        List<Recipe> recipes = recipesResponse.getRecipes();

        return new ModelAndView("recipes", "recipeModel", recipes);

    }

}
