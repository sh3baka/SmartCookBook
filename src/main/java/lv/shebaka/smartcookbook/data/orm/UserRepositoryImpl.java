package lv.shebaka.smartcookbook.data.orm;

import lv.shebaka.smartcookbook.data.UserRepository;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.domain.UserFridge;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryImpl extends ORMRepository implements UserRepository {

    @Override
    public void add(User user) {
        session().save(user);
    }

    @Override
    @Transactional
    public Optional<User> findByUsername(String username) {
        User user = (User) session().createCriteria(User.class).
                add(Restrictions.eq("username", username)).uniqueResult();
        return Optional.ofNullable(user);
    }

    @Override
    public void remove(User user) {
        session().delete(user);

    }

    @Override
    @Transactional
    public List<UserFridge> getUserProductsByUsername(User user) {

        return session().createCriteria(UserFridge.class).
                add(Restrictions.eq("user", user )).list();


    }


    //    @Override
//    public List<User> getAllUsers() {
//        return session().createCriteria(User.class).list();
//    }
}
