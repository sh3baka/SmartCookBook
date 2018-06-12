package lv.shebaka.smartcookbook.logic.addUser;

import lv.shebaka.smartcookbook.data.UserRepository;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.AddResponse;
import lv.shebaka.smartcookbook.logic.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AddUserServiceImpl implements AddUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddUserValidatorImpl addUserValidatorImpl;

    @Transactional
    public AddResponse addUser(String username, String password, String repeatPassword) {

        List<Error> validationErrors = addUserValidatorImpl.validate(username, password, repeatPassword);
        if (!validationErrors.isEmpty()) {
            return new AddResponse(false, validationErrors);
        } else {

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userRepository.add(user);

            return new AddResponse(true, null);
        }
    }
}

