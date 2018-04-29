package lv.shebaka.smartcookbook.logic.userregistration;

import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public interface UserRegistrationValidator {

    List<Error> validate(UserRegistrationRequest request);

}
