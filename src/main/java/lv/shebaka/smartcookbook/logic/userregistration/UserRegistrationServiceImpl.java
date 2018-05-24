package lv.shebaka.smartcookbook.logic.userregistration;

import lv.shebaka.smartcookbook.data.UserRepository;
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
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserRegistrationResponse register(UserRegistrationRequest request) {
        List<Error> validationErrors = userRegistrationValidator.validate(request);
        if(!validationErrors.isEmpty()){
            return new UserRegistrationResponse(validationErrors);
        }

        User user = createUser()
                .withUsername(request.getLogin())
                .withPassword(request.getPassword())
                .build();

        userRepository.add(user);

        return new UserRegistrationResponse(user.getId());
    }
}
