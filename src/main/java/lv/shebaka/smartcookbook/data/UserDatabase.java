package lv.shebaka.smartcookbook.data;

import lv.shebaka.smartcookbook.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDatabase {

    void add(User user);

    Optional<User> findByUsername(String username);

    void remove(User user);

 //   List<User> getAllUsers();

}
