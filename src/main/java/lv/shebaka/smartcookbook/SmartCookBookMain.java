package lv.shebaka.smartcookbook;

import lv.shebaka.smartcookbook.configs.SpringAppConfig;
import lv.shebaka.smartcookbook.views.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmartCookBookMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, applicationContext.getBean(AddRecipeView.class));
        actionMap.put(2, applicationContext.getBean(DeleteRecipeView.class));
        actionMap.put(3, applicationContext.getBean(ShowRecipeView.class));
        actionMap.put(4, applicationContext.getBean(AddUserView.class));
        actionMap.put(5, applicationContext.getBean(DeleteUserView.class));
        actionMap.put(0, applicationContext.getBean(ExitView.class));

        while (true) {
            printMenu();
            int menuItem = getMenuItem();
            View view = actionMap.get(menuItem);
            view.execute();
        }
    }
    public static void printMenu() {

        System.out.println("Программное Меню:");
        System.out.println("1. Добавить рецепт");
        System.out.println("2. Удалить рецепт из списка");
        System.out.println("3. Вывести рецепты в консоль");
        System.out.println("4. Добавить пользователя");
        System.out.println("5. Удалить пользователя");
        System.out.println("0. Выход");


    }


    private static int getMenuItem() {
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }


}


