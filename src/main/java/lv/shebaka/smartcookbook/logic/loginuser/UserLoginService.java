package lv.shebaka.smartcookbook.logic.loginuser;

import lv.shebaka.smartcookbook.logic.userregistration.UserRegistrationRequest;

public interface UserLoginService {

    UserLoginResponse logIn(UserLoginRequest request);

}
