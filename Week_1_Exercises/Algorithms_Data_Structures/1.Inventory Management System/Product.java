import java.util.HashMap;
import java.util.Scanner;

public class Product {
    int productId;
    String productName;
    double quantity;
    double price;

    public Product(int productId, String productName, double quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    static HashMap<Integer, Product> store = new HashMap<>();

    public static void addProduct(int productId, String productName, double quantity, double price) {
        if (!store.containsKey(productId)) {
            store.put(productId, new Product(productId, productName, quantity, price));
            System.out.println("The product with ID " + productId + " has been added.");
        } else {
            System.out.println("The product with ID " + productId + " already exists.");
            System.out.println("Want to update the quantity of the item? [Y/N]");
            Scanner sc = new Scanner(System.in);
            String response = sc.next();
            if (response.equalsIgnoreCase("Y")) {
                System.out.println("Enter the quantity to add:");
                double addQuantity = sc.nextDouble();
                updateQuantity(productId, addQuantity);
            }
        }
        displayInventory();
    }

    public static void deleteProduct(int productId) {
        if (store.containsKey(productId)) {
            store.remove(productId);
            System.out.println("The product with ID " + productId + " has been deleted.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        displayInventory();
    }

    public static void updateQuantity(int productId, double quantityChange) {
        if (store.containsKey(productId)) {
            Product product = store.get(productId);
            Scanner sc = new Scanner(System.in);
            System.out.println("Want to update the quantity of the item? [1: increase  2: decrease]");
            int response = sc.nextInt();
            if (response == 1) {
                product.quantity += quantityChange;
            } else if (response == 2) {
                product.quantity -= quantityChange;
            } else {
                System.out.println("Please enter either 1 or 2.");
            }
            System.out.println("Updated product: " + product);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        displayInventory();
    }

    public static void updatePrice(int productId, double priceChange) {
        if (store.containsKey(productId)) {
            Product product = store.get(productId);
            Scanner sc = new Scanner(System.in);
            System.out.println("Want to update the price of the item? [1: increase  2: decrease]");
            int response = sc.nextInt();
            if (response == 1) {
                product.price += priceChange;
            } else if (response == 2) {
                product.price -= priceChange;
            } else {
                System.out.println("Please enter either 1 or 2.");
            }
            System.out.println("Updated product: " + product);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        displayInventory();
    }

    public static void updateProductName(int productId, String newProductName) {
        if (store.containsKey(productId)) {
            Product product = store.get(productId);
            Scanner sc = new Scanner(System.in);
            System.out.println("Want to update the name of the item? [Y/N]");
            String response = sc.next();
            if (response.equalsIgnoreCase("Y")) {
                product.productName = newProductName;
                System.out.println("Updated product: " + product);
            }
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        displayInventory();
    }

    public static void displayInventory() {
        System.out.println("------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s |\n", "Product ID", "Product Name", "Quantity", "Price");
        System.out.println("------------------------------------------------------");
        for (Product product : store.values()) {
            System.out.printf("| %-10d | %-20s | %-10.2f | %-10.2f |\n", product.productId, product.productName, product.quantity, product.price);
        }
        System.out.println("------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----- Inventory Management System -----");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Update Quantity of the Product");
            System.out.println("4. Update Price of the Product");
            System.out.println("5. Update Name of the Product");
            System.out.println("6. Display Inventory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();
                    System.out.print("Enter Product Name: ");
                    String productName = sc.next();
                    System.out.print("Enter Product Quantity: ");
                    double quantity = sc.nextDouble();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    addProduct(productId, productName, quantity, price);
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    int deleteId = sc.nextInt();
                    deleteProduct(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Product ID: ");
                    int updateQuantityId = sc.nextInt();
                    System.out.print("Enter Quantity Change: ");
                    double quantityChange = sc.nextDouble();
                    updateQuantity(updateQuantityId, quantityChange);
                    break;
                case 4:
                    System.out.print("Enter Product ID: ");
                    int priceUpdateId = sc.nextInt();
                    System.out.print("Enter Price Change: ");
                    double priceChange = sc.nextDouble();
                    updatePrice(priceUpdateId, priceChange);
                    break;
                case 5:
                    System.out.print("Enter Product ID: ");
                    int nameUpdateId = sc.nextInt();
                    System.out.print("Enter New Product Name: ");
                    String newProductName = sc.next();
                    updateProductName(nameUpdateId, newProductName);
                    break;
                case 6:
                    displayInventory();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
