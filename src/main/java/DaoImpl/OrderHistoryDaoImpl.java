package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Dao.OrderHistoryDao;
import Modules.OrderHistory;
import Modules.OrderItem;
import Modules.OrderTable;
import Modules.Product;
import Modules.User;

public class OrderHistoryDaoImpl implements OrderHistoryDao {

    private SessionFactory sessionFactory;

    public OrderHistoryDaoImpl() {
        sessionFactory = new Configuration()
                .configure() // loads hibernate.cfg.xml
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(OrderItem.class)
                .addAnnotatedClass(OrderTable.class)
                .addAnnotatedClass(OrderHistory.class)
                .buildSessionFactory();
    }

    @Override
    public int addOrderHistory(OrderHistory o) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(o);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<OrderHistory> getAllOrderHistory(int userId) {
        try (Session session = sessionFactory.openSession()) {
            Query<OrderHistory> query = session.createQuery("FROM OrderHistory WHERE user.id = :userId", OrderHistory.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

    @Override
    public OrderHistory getOrderHistory(int orderHistoryId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(OrderHistory.class, orderHistoryId);
        }
    }
}
