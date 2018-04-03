package lv.shebaka.smartcookbook.logic;

import lv.shebaka.smartcookbook.data.UserORMDatabase;
import lv.shebaka.smartcookbook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteUserService {

    @Autowired
    private UserORMDatabase userORMDatabase;

    public boolean deleteUser(String username) {
        Optional<User> foundUser = userORMDatabase.findByUsername(username);
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            userORMDatabase.remove(user);
            return true;
        } else {
            return false;
        }

    }
}
