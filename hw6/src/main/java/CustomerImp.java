import org.hibernate.Session;
import java.util.List;

public class CustomerImp implements DaoCustomer{

    private SessionFactoryUtils sessionFactoryUtils;

    public CustomerImp(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Customer findById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.getTransaction().commit();
        return customer;

    }

    @Override
    public List<Customer> findAll() {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        List<Customer> customers = session.createQuery("select c from Customer c").getResultList();
        session.getTransaction().commit();
        return customers;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.createQuery("delete Customer c where c.id =: id").
                setParameter("id",id).
                executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.saveOrUpdate(customer);
        session.getTransaction().commit();
    }

}
