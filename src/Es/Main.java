package Es;

import Es.entities.Customer;
import Es.entities.Order;
import Es.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Product prodotto1 = new Product("Lavatrice", "boys", 500);
        Product prodotto2 = new Product("T-shirt", "boys", 20);
        Product prodotto3 = new Product("trapano a colonna", "boys", 1000);
        Product prodotto4 = new Product("il guardiano degli innocenti", "books", 200);
        Product prodotto5 = new Product("ritorno al nuovo mondo", "books", 50);
        Product prodotto6 = new Product("il ritorno del re", "books", 300);
        Product prodotto7 = new Product("passeggino", "baby", 300);
        Product prodotto8 = new Product("altro", "baby", 300);
        Customer cliente1 = new Customer("pippo", 2);
        Customer cliente2 = new Customer("pluto", 2);
        Customer cliente3 = new Customer("tizio", 2);
        ArrayList<Product> listaProd = new ArrayList<>();
        listaProd.add(prodotto1);
        listaProd.add(prodotto2);
        listaProd.add(prodotto3);
        listaProd.add(prodotto4);
        listaProd.add(prodotto5);
        listaProd.add(prodotto6);

        Order ordine1 = new Order(cliente1, listaProd);

        ArrayList<Product> listaProd2 = new ArrayList<>();
        listaProd2.add(prodotto5);
        listaProd2.add(prodotto6);
        listaProd2.add(prodotto7);
        listaProd2.add(prodotto8);

        Order ordine2 = new Order(cliente2, listaProd2);

        ArrayList<Product> listaProd3 = new ArrayList<>();
        listaProd3.add(prodotto1);
        listaProd3.add(prodotto2);
        listaProd3.add(prodotto3);
        listaProd3.add(prodotto4);
        listaProd3.add(prodotto5);
        listaProd3.add(prodotto6);
        listaProd3.add(prodotto7);
        listaProd3.add(prodotto8);

        Order ordine3 = new Order(cliente3, listaProd3);

        Predicate<Product> isBooks = product -> product.getCategory().equals("books");
        List<Product> books = listaProd.stream().filter(isBooks.and(product -> product.getPrice() > 100)).toList();
        System.out.println("lista prodotti books");
        System.out.println(books);

        ArrayList<Order> orders = new ArrayList<>();

        orders.add(ordine1);
        orders.add(ordine2);
        orders.add(ordine3);

        LocalDate febVentuno = LocalDate.of(2021, 2, 1);
        LocalDate aprVentuno = LocalDate.of(2021, 4, 1);
        LocalDate marVentuno = LocalDate.of(2021, 3, 20);


        List<Order> babyOrd = orders.stream().filter(order ->
                order.getProducts().stream().anyMatch(product -> product.getCategory().equals("baby"))
        ).toList();
        System.out.println("lista ordini con almeno un prodotto baby");
        System.out.println(babyOrd);


        List<Product> boysProds = listaProd3.stream().filter(product -> product.getCategory().equals("boys")).toList();


        for (int i = 0; i < babyOrd.size(); i++) {
            boysProds.get(i).discountPerc(10);
        }
        System.out.println(boysProds);

        for (int i = 0; i < 2; i++) {
            orders.get(i).setDate(marVentuno);
        }

        Predicate<Order> afterFeb = order -> order.getDate().isAfter(febVentuno);

        System.out.println("ordini nel periodo di tempo");

        List<Order> timeRangeOrds = orders.stream().filter(afterFeb.and(order -> order.getDate().isBefore(aprVentuno))).toList();
        System.out.println(timeRangeOrds);
        HashSet<Product> timeRangeProds = new HashSet<>();

        for (int i = 0; i < timeRangeOrds.size(); i++) {
            timeRangeProds.addAll(timeRangeOrds.get(i).getProducts());
        }

        System.out.println("Prodotti ordinati nel periodo di tempo");
        System.out.println(timeRangeProds);


    }
}
