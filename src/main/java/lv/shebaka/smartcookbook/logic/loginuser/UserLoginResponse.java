package lv.shebaka.smartcookbook.logic.loginuser;

import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public class UserLoginResponse {

    private User user;

    private boolean success;
    private List<Error> errors;

    public UserLoginResponse(User user){
        this.user = user;
        this.success = true;
        this.errors = null;
    }

    public UserLoginResponse(List<Error> errors){
        this.user = null;
        this.success = false;
        this.errors = errors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
