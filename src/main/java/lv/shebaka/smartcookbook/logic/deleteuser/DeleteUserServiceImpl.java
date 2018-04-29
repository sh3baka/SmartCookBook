package lv.shebaka.smartcookbook.logic.deleteuser;

import lv.shebaka.smartcookbook.data.orm.UserDatabaseImpl;
import lv.shebaka.smartcookbook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class DeleteUserServiceImpl implements DeleteUserService{

    @Autowired
    private UserDatabaseImpl userRepositoryImpl;

    @Transactional
    public boolean deleteUser(String username) {
        Optional<User> foundUser = userRepositoryImpl.findByUsername(username);
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            userRepositoryImpl.remove(user);
            return true;
        } else {
            return false;
        }

    }
}
