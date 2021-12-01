import org.hibernate.Session;

import java.util.List;

public class ProductDaoImp implements ProductDao {
    private SessionFactoryUt sessionFactoryUt;

    public ProductDaoImp(SessionFactoryUt sessionFactoryUt) {
        this.sessionFactoryUt = sessionFactoryUt;
    }

    @Override
    public Product findById(Long id) {
        Session session = sessionFactoryUt.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;

    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactoryUt.getSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("select p from Product p").getResultList();
        session.getTransaction().commit();
        return products;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactoryUt.getSession();
        session.beginTransaction();
        session.createQuery("delete   Product p where p.id =: id").
                setParameter("id",id).
                executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void saveOrUpdate(Product product) {
        Session session = sessionFactoryUt.getSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
    }
}
