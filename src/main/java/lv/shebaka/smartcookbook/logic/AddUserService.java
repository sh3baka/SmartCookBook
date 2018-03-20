package lv.shebaka.smartcookbook.logic;

import lv.shebaka.smartcookbook.User;
import lv.shebaka.smartcookbook.data.UserRealDatabase;

import java.util.List;

public class AddUserService {
    private UserRealDatabase userRealDatabase;
    private AddUserValidator addUserValidator;

    public AddUserService(UserRealDatabase userRealDatabase, AddUserValidator addUserValidator) {
        this.userRealDatabase = userRealDatabase;
        this.addUserValidator = addUserValidator;
    }

    public AddResponse addUser(String username, String password,String repeatPassword, String email) {

        List<Error> validationErrors = addUserValidator.validate(username, password, repeatPassword, email);
        if (!validationErrors.isEmpty()) {
            return new AddResponse(true, validationErrors);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userRealDatabase.add(user);

        return new AddResponse(true, null);
    }
}

