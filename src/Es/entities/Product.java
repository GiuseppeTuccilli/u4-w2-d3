package Es.entities;

import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(String name, String cat, double price) {
        Random rdm = new Random();
        this.id = 1000 + rdm.nextLong(1001);
        this.name = name;
        this.category = cat;
        this.price = price;

    }

    public double getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public void discountPerc(int dis) {
        this.price = this.price * (1 - ((double) dis / 100));
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
