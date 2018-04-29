package lv.shebaka.smartcookbook.logic.adduser;

import lv.shebaka.smartcookbook.data.UserDatabaseImpl;
import lv.shebaka.smartcookbook.logic.Error;
import lv.shebaka.smartcookbook.logic.addrecipe.AddRecipeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class AddUserValidatorImpl implements AddUserValidator{

    @Autowired private UserDatabaseImpl userRepositoryImpl;

    public List<Error> validate(String username, String password, String repeatPassword) {
        List<Error> errors = new ArrayList<>();
        validateUsername(username).ifPresent(errors::add);
        validatePassword(password).ifPresent(errors::add);
        validateRepeatePassword(repeatPassword).ifPresent(errors::add);
        passwordMatch(repeatPassword, password).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateUsername(String username){
        if (username == null || username.isEmpty()){
            return Optional.of(new Error("username" , "Must not be empty"));
        }else {
            return Optional.empty();
        }
    }
    private Optional<Error> validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return Optional.of(new Error("password", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }
    private Optional<Error> validateRepeatePassword(String repeatPassword){
        if (repeatPassword == null || repeatPassword.isEmpty()){
            return Optional.of(new Error("repeatPassword" , "Repeated password must not be empty "));
        }else {
            return Optional.empty();
        }
    }
    private Optional<Error> passwordMatch(String repeatPassword, String password){
        if ((repeatPassword != null || password != null) && !password.equals(repeatPassword)){
            return Optional.of(new Error("repeatPassword" , "Passwords don't match "));
        }else {
            return Optional.empty();
        }
    }

}
