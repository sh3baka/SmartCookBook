package lv.shebaka.smartcookbook.logic.userregistration;

import lv.shebaka.smartcookbook.data.UserRepository;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRegistrationValidatorImpl implements UserRegistrationValidator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Error> validate(UserRegistrationRequest request) {
        List<Error> errors = new ArrayList<>();

        return errors;
    }

    private Optional<Error> validationLogin(String login) {
        if (login == null || login.isEmpty()) {
            return Optional.of(new Error("login", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validatePassword(String password){
        if(password == null || password.isEmpty()){
            return Optional.of(new Error("password", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateDuplicateLogin(String login){
        if(login != null && !login.isEmpty()){
            Optional<User> userOptional = userRepository.findByUsername(login);
            if(userOptional.isPresent()){
                return Optional.of(new Error("login", "Already exists"));
            }
        }
        return Optional.empty();
    }
}
