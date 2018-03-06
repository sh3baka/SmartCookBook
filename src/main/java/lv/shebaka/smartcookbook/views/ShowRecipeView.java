package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.Recipe;
import lv.shebaka.smartcookbook.data.RecipeDatabase;

public class ShowRecipeView implements View {

    private RecipeDatabase database;

    public ShowRecipeView(RecipeDatabase database){
        this.database = database;
    }

    @Override
    public void execute() {

        System.out.println();
        System.out.println("Выводим все рецепты в списке");

        for(Recipe recipe : database.getAllRecipes()){
            System.out.println(recipe.getTitle() + "[" + recipe.getDesc() + "]");
        }

        System.out.println("Все рецепты выведены");
        System.out.println();

    }
}

