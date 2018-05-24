package lv.shebaka.smartcookbook.logic.deleteuser;

import lv.shebaka.smartcookbook.data.UserRepository;
import lv.shebaka.smartcookbook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class DeleteUserServiceImpl implements DeleteUserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean deleteUser(String username) {
        Optional<User> foundUser = userRepository.findByUsername(username);
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            userRepository.remove(user);
            return true;
        } else {
            return false;
        }

    }
}
