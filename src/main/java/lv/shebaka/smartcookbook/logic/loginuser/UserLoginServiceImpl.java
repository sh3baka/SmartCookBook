package lv.shebaka.smartcookbook.logic.loginuser;

import lv.shebaka.smartcookbook.data.UserRepository;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginValidator validator;
    @Autowired
    private UserRepository database;


    @Override
    public UserLoginResponse logIn(UserLoginRequest request) {
        List<Error> validateErrors = validator.validate(request);
        if (!validateErrors.isEmpty()) {
            return new UserLoginResponse(validateErrors);
        } else {


            Optional<User> user = database.findByUsername(request.getUsername());


            return new UserLoginResponse(user.get());
        }
    }
}
