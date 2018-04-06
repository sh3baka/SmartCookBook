package lv.shebaka.smartcookbook.logic;

import lv.shebaka.smartcookbook.data.UserORMDatabase;
import lv.shebaka.smartcookbook.data.UserRealDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class AddUserValidator {

    @Autowired private UserORMDatabase userORMDatabase;

    List<Error> validate(String username, String password, String repeatPassword, String email) {
        List<Error> errors = new ArrayList<>();
        validateUsername(username).ifPresent(errors::add);
        validatePassword(password).ifPresent(errors::add);
        validateEmail(email).ifPresent(errors::add);
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
    private Optional<Error> validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return Optional.of(new Error("email", "Must not be empty"));
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
