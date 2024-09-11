package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Dao.UserDao;
import Modules.User;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImpl() {
        sessionFactory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
    }

    @Override
    public int addUser(User u) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(u);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User", User.class);
        List<User> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public User getUser(int userId) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        session.close();
        return user;
    }

    @Override
    public int updateUser(User u) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(u);  // Use merge instead of update
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int deleteUser(int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, userId);
        if (user != null) {
            session.delete(user);
        }
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public User getUser(String email) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        User user = query.uniqueResult();
        session.close();
        return user;
    }
}
