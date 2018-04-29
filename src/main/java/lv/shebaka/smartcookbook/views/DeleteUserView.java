package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.logic.deleteuser.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteUserView implements View {
    @Autowired
    private DeleteUserService deleteUserService;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Удалим пользователя из списка");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя пользователя:");
        final String username = scan.nextLine();

        boolean isRemoved = deleteUserService.deleteUser(username);

        if(isRemoved){
            System.out.println("Рецепт " + username + " был удален из списка");
        } else {
            System.out.println("Рецепт " + username + " не найден в списке");
        }

        System.out.println("Отлично!");
        System.out.println();
    }
}
