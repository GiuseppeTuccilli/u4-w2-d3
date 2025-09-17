package Es;

import Es.entities.Customer;
import Es.entities.Order;
import Es.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Product prodotto1 = new Product("Lavatrice", "elettrodomestici", 500);
        Product prodotto2 = new Product("T-shirt", "vestiti", 20);
        Product prodotto3 = new Product("trapano a colonna", "fai da te", 1000);
        Product prodotto4 = new Product("il guardiano degli innocenti", "books", 200);
        Product prodotto5 = new Product("ritorno al nuovo mondo", "books", 50);
        Product prodotto6 = new Product("il ritorno del re", "books", 300);
        Customer cliente1 = new Customer("pippo", 3);
        Customer cliente2 = new Customer("pluto", 2);
        Customer cliente3 = new Customer("tizio", 1);
        ArrayList<Product> listaProd = new ArrayList<>();
        listaProd.add(prodotto1);
        listaProd.add(prodotto2);
        listaProd.add(prodotto3);
        listaProd.add(prodotto4);
        listaProd.add(prodotto5);
        listaProd.add(prodotto6);
        Order ordine1 = new Order(cliente1, listaProd);

        Predicate<Product> isBooks = product -> product.getCategory().equals("books");
        List<Product> books = listaProd.stream().filter(isBooks.and(product -> product.getPrice() > 100)).toList();
        System.out.println(books);

    }
}
