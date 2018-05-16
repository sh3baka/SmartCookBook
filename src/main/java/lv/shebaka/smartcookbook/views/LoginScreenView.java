package lv.shebaka.smartcookbook.views;

import lv.shebaka.smartcookbook.logic.loginuser.UserLoginRequest;
import lv.shebaka.smartcookbook.logic.loginuser.UserLoginResponse;
import lv.shebaka.smartcookbook.logic.loginuser.UserLoginService;
import lv.shebaka.smartcookbook.logic.loginuser.UserLoginServiceImpl;
import lv.shebaka.smartcookbook.logic.userregistration.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LoginScreenView implements View {

    @Autowired
    private UserLoginService userLoginService;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Введите Логин:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        System.out.print("Введите пароль:");
        String password = scan.nextLine();

        UserLoginResponse response = userLoginService.logIn(new UserLoginRequest(username, password));

        if (response.isSuccess()){
            System.out.println("Welcome");
        } else {
            response.getErrors().forEach(error -> {
                System.out.println("Ошибка в поле = "+ error.getField());
                System.out.println("Ошибка = "+ error.getErrorMsg());
            });
        }



    }
}
