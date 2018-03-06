package lv.shebaka.smartcookbook.views;


public class MenuView implements View {

    @Override
    public void execute() {

        System.out.println("Программное Меню:");
        System.out.println("1. Добавить рецепт");
        System.out.println("2. Удалить рецепт из списка");
        System.out.println("3. Вывести рецепты в консоль");
        System.out.println("4. Выход");


    }
}
