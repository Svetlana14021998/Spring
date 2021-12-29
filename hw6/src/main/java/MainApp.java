import org.hibernate.Session;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            Session session = sessionFactoryUtils.getSession();

            session.beginTransaction();
            Customer customer = sessionFactoryUtils.getSession().get(Customer.class, 1L);
            session.getTransaction().commit();
            Service service = new Service(sessionFactoryUtils);
            List<Product> list = service.findProductsByCustomerId(customer.getId());
            System.out.println("for customer " + customer.getName() + " Shop list: " + list);


           /* session.beginTransaction();
            Product product = sessionFactoryUtils.getSession().get(Product.class, 1L);
            session.getTransaction().commit();
            Service service = new Service(sessionFactoryUtils);
            List<Customer> list = service.findCustomersByProductId(product.getId());
            System.out.println("for product: " + product.getName() + " customers: " + list);
*/


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }

}
