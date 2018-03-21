package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.data.UserRealDatabase;
import lv.shebaka.smartcookbook.logic.AddResponse;
import lv.shebaka.smartcookbook.logic.AddUserService;
import lv.shebaka.smartcookbook.logic.AddUserValidator;

import java.util.Scanner;

public class UserRegistrationView implements View {

    AddUserService addUserService ;
    public UserRegistrationView(UserRealDatabase userRealDatabase){
        AddUserValidator addUserValidator = new AddUserValidator(userRealDatabase);
        this.addUserService = new AddUserService(userRealDatabase,addUserValidator);
    }
    @Override
    public void execute() {
        System.out.println();
        System.out.println("Давайте добавим ваш пользователя!");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название Логин:");
        String username = scan.nextLine();
        System.out.print("Введите ваш пароль:");
        String password = scan.nextLine();
        System.out.print("Введите вашу пароль еще раз:");
        String passwordRepeat = scan.nextLine();
        System.out.print("Введите вашу почту:");
        String email = scan.nextLine();
        AddResponse response = addUserService.addUser(username, password , passwordRepeat, email);

        if (response.isSuccess()){
            System.out.println("Пользователь успешно зарегестрирован!");
            System.out.println();
            System.out.println("Отлично!");
            System.out.println();
        }else{
            response.getErrors().forEach(error -> {
                System.out.println("Ошибка в поле = "+ error.getField());
                System.out.println("Ошибка = "+ error.getErrorMsg());
            });
        }
    }
}
