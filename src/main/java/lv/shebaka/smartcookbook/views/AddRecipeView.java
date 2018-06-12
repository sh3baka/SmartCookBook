package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.logic.AddResponse;
import lv.shebaka.smartcookbook.logic.addRecipe.AddRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddRecipeView implements View {

    @Autowired
    private AddRecipeService addRecipeService;


    @Override
    public void execute() {
        System.out.println();
        System.out.println("Давайте добавим ваш рецепт!");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название рецепта:");
        String title = scan.nextLine();
        System.out.print("Введите ваш рецепт:");
        String desc = scan.nextLine();

        AddResponse response = addRecipeService.addRecipe(title, desc);
        if (response.isSuccess()) {
            System.out.println("Рецепт добавлен в список!");
            System.out.println();
            System.out.println("Отлично!");
            System.out.println();
        } else {
            response.getErrors().forEach(error -> {
                System.out.println("Ошибка в поле = " + error.getField());
                System.out.println("Ошибка = " + error.getErrorMsg());
            });
        }
    }
}
