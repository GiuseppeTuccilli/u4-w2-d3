package Es;

import Es.entities.Customer;
import Es.entities.Order;
import Es.entities.Product;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Product prodotto1 = new Product("Lavatrice", "elettrodomestici", 500);
        Product prodotto2 = new Product("T-shirt", "vestiti", 20);
        Product prodotto3 = new Product("trapano a colonna", "fai da te", 1000);
        Customer cliente1 = new Customer("pippo", 3);
        Customer cliente2 = new Customer("pluto", 2);
        Customer cliente3 = new Customer("tizio", 1);
        ArrayList<Product> listaProd = new ArrayList<>();
        listaProd.add(prodotto1);
        listaProd.add(prodotto2);
        Order ordine1 = new Order(cliente1, listaProd);
        

    }
}
