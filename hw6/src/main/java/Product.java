import javax.persistence.*;
import java.util.List;


@Entity
@Table (name= "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id")
    private Long id;

    @Column (name ="name")
    private String name;

    @Column (name ="cost")
    private Long cost;

    @ManyToMany
    @JoinTable(
            name ="customers_products",
            joinColumns = @JoinColumn(name ="product_id"),
            inverseJoinColumns = @JoinColumn(name ="customer_id")
    )
    private List <Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{ id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

}
