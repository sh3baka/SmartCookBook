package lv.shebaka.smartcookbook.logic.userregistration;

import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public class UserRegistrationResponce {

    private Long userId;
    private boolean success;
    private List<Error> errors;

    public UserRegistrationResponce(Long userId){
        this.userId = userId;
        this.success = true;
        this.errors = null;
    }

    public UserRegistrationResponce(List<Error> errors){
        this.userId = null;
        this.success = false;
        this.errors = errors;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
