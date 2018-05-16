package lv.shebaka.smartcookbook.logic.loginuser;

import lv.shebaka.smartcookbook.data.UserDatabase;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.Error;
import lv.shebaka.smartcookbook.logic.userregistration.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class UserLoginValidatorImpl implements UserLoginValidator {

    @Autowired
    private UserDatabase userDatabase;

    @Override
    public List<Error> validate(UserLoginRequest request) {
        List<Error> errors = new ArrayList<>();

        validateUsername(request.getUsername()).ifPresent(errors::add);
        validateUsernameExist(request.getUsername()).ifPresent(errors::add);
        validatePassword(request.getPassword()).ifPresent(errors::add);
        validateUserPassword(request.getUsername(), request.getPassword()).ifPresent(errors::add);


        return errors;
    }

    private Optional<Error> validateUsername(String username){
        if(username == null || username.isEmpty()){
            return Optional.of(new Error("username", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateUsernameExist(String username){
        if(username != null && !username.isEmpty()){
            try {
                Optional<User> userOptional = userDatabase.findByUsername(username);
                if(!userOptional.isPresent()) {
                    return Optional.of(new Error("username", "Username not found"));
                }
            } catch (NoSuchElementException e) {
                return Optional.of(new Error("username", "Username not found"));
            }
        }
        return Optional.empty();
    }

    private Optional<Error> validatePassword(String password){
        if(password == null || password.isEmpty()){
            return Optional.of(new Error("password", "Must not be empty"));
        }
            return Optional.empty();
    }

    private Optional<Error> validateUserPassword(String username, String password){
        if (username != null && password != null || !username.isEmpty() && !password.isEmpty()){
            try {
                Optional<User> user = userDatabase.findByUsername(username);
                if(!user.get().getPassword().equals(password)){
                    return Optional.of(new Error("password", "Wrong Password"));
                }
            } catch (NoSuchElementException e) {
                return Optional.of(new Error("password", "Wrong Password"));
            }
        }
        return Optional.empty();
    }


}


