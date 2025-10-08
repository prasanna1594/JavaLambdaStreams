import java.util.*;
import java.util.stream.*;
import java.util.Comparator;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " | " + category + " | " + price;
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 75000, "Electronics"),
            new Product("Phone", 50000, "Electronics"),
            new Product("Shoes", 3000, "Fashion"),
            new Product("Shirt", 1500, "Fashion"),
            new Product("Mixer", 4000, "Home Appliances"),
            new Product("TV", 60000, "Electronics")
        );

        // Group by category
        System.out.println("Products grouped by category:");
        Map<String, List<Product>> grouped = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        grouped.forEach((cat, list) -> System.out.println(cat + ": " + list));

        // Most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> maxByCat = products.stream()
            .collect(Collectors.groupingBy(p -> p.category,
                     Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));
        maxByCat.forEach((cat, prod) -> System.out.println(cat + ": " + prod.get()));

        // Average price of all products
        double avgPrice = products.stream()
            .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage price of all products: " + avgPrice);
    }
}
