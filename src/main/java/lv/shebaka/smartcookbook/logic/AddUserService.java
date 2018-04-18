package lv.shebaka.smartcookbook.logic;

import lv.shebaka.smartcookbook.data.UserORMDatabase;
import lv.shebaka.smartcookbook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class AddUserService {
    @Autowired private UserORMDatabase userORMDatabase;
    @Autowired private AddUserValidator addUserValidator;
    @Transactional
    public AddResponse addUser(String username, String password,String repeatPassword) {

        List<Error> validationErrors = addUserValidator.validate(username, password, repeatPassword);
        if (!validationErrors.isEmpty()) {
            return new AddResponse(false, validationErrors);
        }else {

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userORMDatabase.add(user);

            return new AddResponse(true, null);
        }
    }
}

