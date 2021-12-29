import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface DaoCustomer {

    Customer findById(Long id);
    List<Customer> findAll();
    void deleteById(Long id);
    void saveOrUpdate(Customer customer);
}
