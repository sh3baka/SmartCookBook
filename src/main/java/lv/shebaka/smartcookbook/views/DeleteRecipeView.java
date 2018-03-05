package lv.shebaka.smartcookbook.views;

        import java.util.Scanner;

public class DeleteRecipeView implements View {

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Удалим рецепт из списка");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название рецепта:");
        final String title = scan.nextLine();


        System.out.println("Отлично!");
        System.out.println();
    }


}
