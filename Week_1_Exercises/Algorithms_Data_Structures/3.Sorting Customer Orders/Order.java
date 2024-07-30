import java.util.Scanner;

public class Order {
    int orderId;
    String customerName;
    double totalAmount;

    public Order(int orderId, String customerName, double totalAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public static void BubbleSort(Order[] orders, int size) {
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (orders[j].totalAmount > orders[j + 1].totalAmount) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void QuickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int p = partitionOrders(orders, low, high);

            QuickSort(orders, low, p - 1);
            QuickSort(orders, p + 1, high);
        }
    }

    public static int partitionOrders(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalAmount <= pivot.totalAmount) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.orderId + ", Customer: " + order.customerName + ", Total Amount: $" + order.totalAmount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of orders:");
        int size = sc.nextInt();
        Order[] orders = new Order[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the Order ID:");
            int orderId = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.println("Enter the Customer Name:");
            String customerName = sc.nextLine();
            System.out.println("Enter the Total Amount:");
            double totalAmount = sc.nextDouble();
            orders[i] = new Order(orderId, customerName, totalAmount);
        }

        System.out.println("Orders before sorting:");
        printOrders(orders);

        System.out.println("Orders after Bubble Sort:");
        BubbleSort(orders, size);
        printOrders(orders);

        System.out.println("Orders after Quick Sort:");
        QuickSort(orders, 0, size - 1);
        printOrders(orders);

        sc.close();
    }
}