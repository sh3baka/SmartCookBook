package lv.shebaka.smartcookbook.logic.userRegistration;

import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public interface UserRegistrationValidator {

    List<Error> validate(UserRegistrationRequest request);

}
