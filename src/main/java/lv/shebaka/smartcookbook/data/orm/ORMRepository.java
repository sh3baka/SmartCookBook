package lv.shebaka.smartcookbook.data.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ORMRepository {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session session(){return sessionFactory.getCurrentSession();}

}
