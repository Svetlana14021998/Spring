import org.hibernate.Session;
import java.util.List;

public class ProductImp implements DaoProduct {

    private SessionFactoryUtils sessionFactoryUtils;


    public ProductImp(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;

    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("select p from Product p").getResultList();
        session.getTransaction().commit();
        return products;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.createQuery("delete   Product p where p.id =: id").
                setParameter("id",id).
                executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void saveOrUpdate(Product product) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
    }
}
