package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Dao.OrderTableDao;
import Modules.OrderItem;
import Modules.OrderTable;
import Modules.Product;
import Modules.User;

public class OrderTableDaoImpl implements OrderTableDao {

    private SessionFactory sessionFactory;

    public OrderTableDaoImpl() {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(OrderTable.class)
                .addAnnotatedClass(OrderItem.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    @Override
    public int addOrderTable(OrderTable o) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
        session.close();
        return 1; // Return 1 to indicate success
    }

    @Override
    public List<OrderTable> getAllOrderTable(int userId) {
        Session session = sessionFactory.openSession();
        Query<OrderTable> query = session.createQuery("from OrderTable where user.id = :userId", OrderTable.class);
        query.setParameter("userId", userId);
        List<OrderTable> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public OrderTable getOrderTable(int orderId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        OrderTable orderTable = session.get(OrderTable.class, orderId);
        transaction.commit();
        session.close();
        return orderTable;
    }
    
    public int updateUser(OrderTable u) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(u);  // Use merge instead of update
        transaction.commit();
        session.close();
        return 1;
    }


    public int getMaxOrder() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        // HQL query to get the maximum orderId
        String hql = "SELECT MAX(o.orderId) FROM OrderTable o";
        Query<Integer> query = session.createQuery(hql, Integer.class);
        Integer maxOrderId = query.uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        
        return maxOrderId != null ? maxOrderId : 0; // Return 0 if no orders are found
    }
}
