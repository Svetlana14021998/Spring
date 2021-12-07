import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface DaoProduct {

    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    void saveOrUpdate(Product product);
}
