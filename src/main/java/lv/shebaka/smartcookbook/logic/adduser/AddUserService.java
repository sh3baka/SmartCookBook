package lv.shebaka.smartcookbook.logic.adduser;

import lv.shebaka.smartcookbook.logic.AddResponse;

public interface AddUserService {

    AddResponse addUser(String username, String password, String repeatPassword);

}
