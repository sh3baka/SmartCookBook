package lv.shebaka.smartcookbook.data.orm;

import lv.shebaka.smartcookbook.data.FridgeRepository;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.domain.UserFridge;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FridgeRepositoryImpl extends ORMRepository implements FridgeRepository {

    @Override
    @Transactional
    public void clearUserFridge(User user) {
        List<UserFridge> foundUser = (List<UserFridge>) session().
                createCriteria(UserFridge.class).
                add(Restrictions.eq("user", user)).list();

        for (UserFridge userFridge : foundUser) {
            session().delete(userFridge);
        }
    }

    @Override
    public void addToUserFridge(UserFridge userFridge) {
        session().save(userFridge);
    }
}
