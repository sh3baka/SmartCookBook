package lv.shebaka.smartcookbook.data;

import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.domain.UserFridge;

public interface FridgeRepository {

    void clearUserFridge(User user);

    void addToUserFridge(UserFridge userFridge);

}
