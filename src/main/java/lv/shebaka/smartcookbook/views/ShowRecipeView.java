package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.data.orm.RecipeDatabaseImpl;
import lv.shebaka.smartcookbook.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowRecipeView implements View {

//    @Autowired private RecipeDatabaseImpl recipeDatabaseImpl;

    @Override
    public void execute() {

        System.out.println();
        System.out.println("Выводим все рецепты в списке");

//        for(Recipe recipe : recipeDatabaseImpl.getAllRecipes()){
//            System.out.println(recipe.getTitle() + " [" + recipe.getDesc() + "]");
//        }

        System.out.println("Все рецепты выведены");
        System.out.println();

    }
}

