package lv.shebaka.smartcookbook.data;

import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.domain.UserFridge;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void add(User user);

    Optional<User> findByUsername(String username);

    void remove(User user);

    List<UserFridge> getUserProductsByUsername(User user);

    //   List<User> getAllUsers();

}
