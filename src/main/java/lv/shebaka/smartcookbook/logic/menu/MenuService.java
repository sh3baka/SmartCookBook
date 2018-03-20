package lv.shebaka.smartcookbook.logic.menu;


import lv.shebaka.smartcookbook.data.RecipeRealDatabase;
import lv.shebaka.smartcookbook.data.UserRealDatabase;
import lv.shebaka.smartcookbook.views.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuService {
    RecipeRealDatabase realDatabase = new RecipeRealDatabase();
    UserRealDatabase userRealDatabase = new UserRealDatabase();

    ExitView exitView = new ExitView();
    AddRecipeView addRecipeView = new AddRecipeView(realDatabase);
    DeleteRecipeView deleteRecipeView = new DeleteRecipeView(realDatabase);
    ShowRecipeView showRecipeView = new ShowRecipeView(realDatabase);
    MenuView menuView = new MenuView();
    UserRegistrationView userRegistrationView = new UserRegistrationView(userRealDatabase);


    public MenuService() {
        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, addRecipeView);
        actionMap.put(2, deleteRecipeView);
        actionMap.put(3, showRecipeView);
        actionMap.put(4, userRegistrationView);
        actionMap.put(0, exitView);

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

