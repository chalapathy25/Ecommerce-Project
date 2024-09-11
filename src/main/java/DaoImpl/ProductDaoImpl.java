package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Dao.ProductDao;
import Modules.Product;

public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    public ProductDaoImpl() {
        sessionFactory = new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
    }

    @Override
    public int addProduct(Product p) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(p);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM Product", Product.class);
        List<Product> resultList = query.list();
        session.close();
        return resultList;
    }

    @Override
    public Product getProduct(int pId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, pId);
        transaction.commit();
        session.close();
        return product;
    }

    @Override
    public int updateProduct(Product p) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(p);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int deleteUser(int pId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, pId);
        if (product != null) {
            session.delete(product);
        }
        transaction.commit();
        session.close();
        return 1;
    }
}
