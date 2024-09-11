package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Dao.OrderItemDao;
import Modules.OrderItem;
import Modules.OrderTable;
import Modules.Product;
import Modules.User;

public class OrderItemDaoImpl implements OrderItemDao {

    private SessionFactory sessionFactory;

    public OrderItemDaoImpl() {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(OrderTable.class)
                .addAnnotatedClass(OrderItem.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    @Override
    public int addOrderItem(OrderItem o) {
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
    public List<OrderItem> getAllOrderItem(int orderId) {
        try (Session session = sessionFactory.openSession()) {
            Query<OrderItem> query = session.createQuery("FROM OrderItem WHERE orderTable.id = :orderId", OrderItem.class);
            query.setParameter("orderId", orderId);
            return query.getResultList();
        }
    }

    @Override
    public OrderItem getOrderItem(int orderItemId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(OrderItem.class, orderItemId);
        }
    }

    @Override
    public int updateOrderItem(OrderItem o) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(o);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteOrderItem(int orderItemId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            OrderItem orderItem = session.get(OrderItem.class, orderItemId);
            session.delete(orderItem);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 0;
        }
    }
}
