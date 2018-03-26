package lv.shebaka.smartcookbook.logic;

import lv.shebaka.smartcookbook.data.UserRealDatabase;
import lv.shebaka.smartcookbook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AddUserService {
    @Autowired private UserRealDatabase userRealDatabase;
    @Autowired private AddUserValidator addUserValidator;

    public AddResponse addUser(String username, String password,String repeatPassword, String email) {

        List<Error> validationErrors = addUserValidator.validate(username, password, repeatPassword, email);
        if (!validationErrors.isEmpty()) {
            return new AddResponse(false, validationErrors);
        }else {

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            userRealDatabase.add(user);

            return new AddResponse(true, null);
        }
    }
}

