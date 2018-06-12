package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.logic.userRegistration.UserRegistrationRequest;
import lv.shebaka.smartcookbook.logic.userRegistration.UserRegistrationResponse;
import lv.shebaka.smartcookbook.logic.userRegistration.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddUserView implements View {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Давайте добавим ваш пользователя!");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название Логин:");
        String username = scan.nextLine();
        System.out.print("Введите ваш пароль:");
        String password = scan.nextLine();

        UserRegistrationResponse response = userRegistrationService.register(new UserRegistrationRequest(username, password));

        if (response.isSuccess()) {
            System.out.println("Пользователь успешно зарегестрирован!");
            System.out.println();
            System.out.println("ID пользователя" + response.getUserId());
            System.out.println();
        } else {
            response.getErrors().forEach(error -> {
                System.out.println("Ошибка в поле = " + error.getField());
                System.out.println("Ошибка = " + error.getErrorMsg());
            });
        }
    }
}
