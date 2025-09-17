package Es.entities;

import java.util.Random;

public class Customer {
    private long id;
    private String name;
    private int tier;

    public Customer(String name, int tier) {
        Random rdm = new Random();
        this.name = name;
        this.tier = tier;
        this.id = 1000 + rdm.nextLong(1001);
    }

    public int getTier() {
        return this.tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
