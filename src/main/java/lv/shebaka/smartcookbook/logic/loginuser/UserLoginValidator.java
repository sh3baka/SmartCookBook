package lv.shebaka.smartcookbook.logic.loginuser;

import lv.shebaka.smartcookbook.logic.Error;
import lv.shebaka.smartcookbook.logic.userregistration.UserRegistrationRequest;

import java.util.List;

public interface UserLoginValidator {

    List<Error> validate(UserLoginRequest request);

}
