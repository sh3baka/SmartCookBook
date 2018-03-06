package lv.shebaka.smartcookbook.Logic;


import lv.shebaka.smartcookbook.views.*;

import java.util.HashMap;
import java.util.Map;

public class MenuService {
    ExitView exitView = new ExitView();
    AddRecipeView addRecipeView = new AddRecipeView();
    DeleteRecipeView deleteRecipeView = new DeleteRecipeView();
    ShowRecipeView showRecipeView = new ShowRecipeView();
    MenuView menuView = new MenuView();
    GetMenuItemFromUser getMenuItemFromUser = new GetMenuItemFromUser();


    public MenuService() {
        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, addRecipeView);
        actionMap.put(2, deleteRecipeView);
        actionMap.put(3, showRecipeView);
        actionMap.put(4, exitView);

        while (true) {
            menuView.execute();
            int menuItem = getMenuItemFromUser.getMenuItem();
            View view = actionMap.get(menuItem);
            view.execute();

        }
    }

}

