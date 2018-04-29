package lv.shebaka.smartcookbook.data;

import lv.shebaka.smartcookbook.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDatabaseImpl implements UserDatabase {
    @Autowired
    SessionFactory sessionFactory;

    private Session session(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(User user) {
        session().save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        User user = (User) session().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
        return Optional.ofNullable(user);
    }

    @Override
    public void remove(User user) {
        session().delete(user);

    }

    @Override
    public List<User> getAllUsers() {
        return session().createCriteria(User.class).list();
    }
}
