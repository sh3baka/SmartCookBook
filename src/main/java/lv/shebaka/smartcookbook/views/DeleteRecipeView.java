package lv.shebaka.smartcookbook.views;

        import lv.shebaka.smartcookbook.Logic.DeleteRecipeService;
        import lv.shebaka.smartcookbook.data.RecipeDatabase;

        import java.util.Scanner;

public class DeleteRecipeView implements View {

    private DeleteRecipeService deleteRecipeService;

    public DeleteRecipeView(RecipeDatabase database){
        this.deleteRecipeService = new DeleteRecipeService(database);
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Удалим рецепт из списка");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название рецепта:");
        final String title = scan.nextLine();

        boolean isRemoved = deleteRecipeService.deleteRecipe(title);

        if(isRemoved){
            System.out.println("Рецепт " + title + " был удален из списка");
        } else {
            System.out.println("Рецепт " + title + " не найден в списке");
        }

        System.out.println("Отлично!");
        System.out.println();
    }


}
