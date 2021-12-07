import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private SessionFactoryUtils sessionFactoryUtils;


    public Service(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public List<Product> findProductsByCustomerId(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        List<Product> products = customer.getProducts();
        List<Product> list = new ArrayList<>();
        for (Product product : products) {
            list.add(product);
        }
       session.getTransaction().commit();
        return list;
    }



    public List<Customer> findCustomersByProductId(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        List<Customer> customers = product.getCustomers();
        List<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            list.add(customer);
        }

       session.getTransaction().commit();
        return list;
    }
}