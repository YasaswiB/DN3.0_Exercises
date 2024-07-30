import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Shoes", "Apparel"));
        products.add(new Product(3, "Watch", "Accessories"));
        products.add(new Product(4, "Smartphone", "Electronics"));
        products.add(new Product(5, "Backpack", "Accessories"));

        // Linear search
        LinearSearch linearSearch = new LinearSearch();
        Product resultLinear = linearSearch.linearSearch(products, "Backpack");
        System.out.println("Linear Search Result: " + resultLinear);

        // Sort products by name for binary search
        Collections.sort(products, (p1, p2) -> 	p1.getProductName().compareTo(p2.getProductName()));

        // Binary search
        BinarySearch binarySearch = new BinarySearch();
        Product resultBinary = binarySearch.binarySearch(products, "Backpack");
        System.out.println("Binary Search Result: " + resultBinary);
    }
}


