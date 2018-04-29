package lv.shebaka.smartcookbook.logic.userregistration;

import lv.shebaka.smartcookbook.data.UserDatabase;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lv.shebaka.smartcookbook.domain.builders.UserBuilder.createUser;

@Component
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationValidator userRegistrationValidator;
    @Autowired
    private UserDatabase userDatabase;

    @Override
    @Transactional
    public UserRegistrationResponce register(UserRegistrationRequest request) {
        List<Error> validationErrors = userRegistrationValidator.validate(request);
        if(!validationErrors.isEmpty()){
            return new UserRegistrationResponce(validationErrors);
        }

        User user = createUser()
                .withUsername(request.getLogin())
                .withPassword(request.getPassword())
                .build();

        userDatabase.add(user);

        return new UserRegistrationResponce(user.getId());
    }
}
