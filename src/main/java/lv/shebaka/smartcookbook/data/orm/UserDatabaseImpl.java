package lv.shebaka.smartcookbook.data.orm;

import lv.shebaka.smartcookbook.data.UserDatabase;
import lv.shebaka.smartcookbook.data.orm.ORMRepository;
import lv.shebaka.smartcookbook.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserDatabaseImpl extends ORMRepository implements UserDatabase {

    @Override
    public void add(User user) {
        session().save(user);
    }

    @Override
    @Transactional
    public Optional<User> findByUsername(String username) {
        User user = (User) session().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
        return Optional.ofNullable(user);
    }

    @Override
    public void remove(User user) {
        session().delete(user);

    }

//    @Override
//    public List<User> getAllUsers() {
//        return session().createCriteria(User.class).list();
//    }
}
