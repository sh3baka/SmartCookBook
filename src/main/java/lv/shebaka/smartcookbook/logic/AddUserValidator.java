package lv.shebaka.smartcookbook.logic;

        import lv.shebaka.smartcookbook.data.UserRealDatabase;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

public class AddUserValidator {

    private UserRealDatabase userRealDatabase;

    public AddUserValidator(UserRealDatabase userRealDatabase) {
        this.userRealDatabase = userRealDatabase;
    }

    List<Error> validate(String username, String password, String repeatPassword, String email) {
        List<Error> errors = new ArrayList<>();
        validateUsername(username).ifPresent(errors::add);
        validatePassword(password).ifPresent(errors::add);
        validateEmail(email).ifPresent(errors::add);
        passwordMatch(password, repeatPassword).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateUsername(String username){
        if (username == null || username.isEmpty()){
            return Optional.of(new Error(username , "Must not be empty"));
        }else {
            return Optional.empty();
        }
    }
    private Optional<Error> validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return Optional.of(new Error(password, "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }
    private Optional<Error> validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return Optional.of(new Error(email, "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }
    private Optional<Error> passwordMatch(String password , String repeatPassword){
        if ((password != null || repeatPassword != null) || (password.isEmpty() || repeatPassword.isEmpty())){
            return Optional.of(new Error(password, "Password or repeated must not be empty or have to match"));
        }else {
            return Optional.empty();
        }
    }

}
