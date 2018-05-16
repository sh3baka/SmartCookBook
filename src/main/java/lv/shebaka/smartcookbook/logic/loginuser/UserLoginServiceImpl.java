package lv.shebaka.smartcookbook.logic.loginuser;

import lv.shebaka.smartcookbook.data.UserDatabase;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.Error;
import lv.shebaka.smartcookbook.logic.userregistration.UserRegistrationRequest;
import lv.shebaka.smartcookbook.logic.userregistration.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginValidator validator;
    @Autowired
    private UserDatabase database;


    @Override
    public UserLoginResponse logIn(UserLoginRequest request) {
        List<Error> validateErrors = validator.validate(request);
        if (!validateErrors.isEmpty()) {
            return new UserLoginResponse(validateErrors);
        } else {


            Optional<User> user = database.findByUsername(request.getUsername());
            user.get().getId();


            return new UserLoginResponse(user.get().getId());
        }
    }
}
