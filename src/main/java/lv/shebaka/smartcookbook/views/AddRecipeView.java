package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.data.recipeRealDatabase;
import lv.shebaka.smartcookbook.logic.addrecipe.AddRecipeResponse;
import lv.shebaka.smartcookbook.logic.addrecipe.AddRecipeService;
import lv.shebaka.smartcookbook.data.RecipeDatabase;
import lv.shebaka.smartcookbook.logic.addrecipe.AddRecipeValidator;

import java.util.Scanner;

public class AddRecipeView implements View {

    private AddRecipeService addRecipeService;

    public AddRecipeView(recipeRealDatabase realDatabase){
        AddRecipeValidator validator = new AddRecipeValidator(realDatabase);
        this.addRecipeService = new AddRecipeService(realDatabase, validator);
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

        AddRecipeResponse response = addRecipeService.addRecipe(title,desc);
        if(response.isSuccess()){
            System.out.println("Рецепт добавлен в список!");
            System.out.println();
        }else {
            response.getErrors().forEach(error -> {
                System.out.println("Ошибка в поле = "+ error.getField());
                System.out.println("Ошибка = "+ error.getErrorMsg());
            });
        }

        System.out.println("Отлично!");
        System.out.println();

    }
}
