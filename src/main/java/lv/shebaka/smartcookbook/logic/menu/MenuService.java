package lv.shebaka.smartcookbook.logic.menu;


import lv.shebaka.smartcookbook.data.JDBCDatabase;
import lv.shebaka.smartcookbook.data.RecipeMemoryDatabase;
import lv.shebaka.smartcookbook.data.recipeRealDatabase;
import lv.shebaka.smartcookbook.views.*;
import lv.shebaka.smartcookbook.data.RecipeDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuService {
    //RecipeDatabase database = new RecipeMemoryDatabase();
    recipeRealDatabase realDatabase = new recipeRealDatabase();

    ExitView exitView = new ExitView();
    AddRecipeView addRecipeView = new AddRecipeView(realDatabase);
    DeleteRecipeView deleteRecipeView = new DeleteRecipeView(realDatabase);
    ShowRecipeView showRecipeView = new ShowRecipeView(realDatabase);
    MenuView menuView = new MenuView();


    public MenuService() {
        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, addRecipeView);
        actionMap.put(2, deleteRecipeView);
        actionMap.put(3, showRecipeView);
        actionMap.put(4, exitView);

        while (true) {
            menuView.execute();
            int menuItem = getMenuItem();
            View view = actionMap.get(menuItem);
            view.execute();

        }
    }

    private int getMenuItem() {
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }


}
