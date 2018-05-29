package lv.shebaka.smartcookbook.logic.addUserFridgeItems;

import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public interface AddToFridgeValidator {

    List<Error> validate(AddToFridgeRequest request);

}
