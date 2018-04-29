package lv.shebaka.smartcookbook.logic.adduser;

import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public interface AddUserValidator {

    List<Error> validate(String username, String password, String repeatPassword);
}
