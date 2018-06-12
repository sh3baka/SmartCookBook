package lv.shebaka.smartcookbook.logic.loginUser;

import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public interface UserLoginValidator {

    List<Error> validate(UserLoginRequest request);

}
