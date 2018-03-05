package lv.shebaka.smartcookbook.views;

import java.util.Scanner;

public class AddRecipeView implements View {

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Давайте добавим ваш рецепт!");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название рецепта:");
        String title = scan.nextLine();
        System.out.print("Введите ваш рецепт:");
        String desc = scan.nextLine();



        System.out.println("Отлично!");
        System.out.println();

    }
}
