package Es.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(Customer cust, List<Product> prods) {
        Random rdm = new Random();
        LocalDate today = LocalDate.now();
        this.id = 1000 + rdm.nextLong(1001);
        this.status = "pending";
        this.orderDate = today;
        this.products = prods;
        this.customer = cust;

    }

    public void setDelivery(LocalDate data) {
        this.deliveryDate = data;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public LocalDate getDate() {
        return this.orderDate;
    }

    public void setDate(LocalDate date) {
        this.orderDate = date;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
