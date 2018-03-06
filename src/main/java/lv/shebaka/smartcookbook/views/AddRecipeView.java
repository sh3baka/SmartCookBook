package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.logic.AddRecipeService;
import lv.shebaka.smartcookbook.data.RecipeDatabase;

import java.util.Scanner;

public class AddRecipeView implements View {

    private AddRecipeService addRecipeService;

    public AddRecipeView(RecipeDatabase database){
        this.addRecipeService = new AddRecipeService(database);
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Давайте добавим ваш рецепт!");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название рецепта:");
        String title = scan.nextLine();
        System.out.print("Введите ваш рецепт:");
        String desc = scan.nextLine();

        addRecipeService.addRecipe(title, desc);

        System.out.println("Отлично!");
        System.out.println();

    }
}
