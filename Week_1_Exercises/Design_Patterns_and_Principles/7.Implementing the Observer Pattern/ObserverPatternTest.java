import java.util.Scanner;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        MobileApp mobileApp1 = new MobileApp("MobileApp1");
        MobileApp mobileApp2 = new MobileApp("MobileApp2");
        WebApp webApp1 = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter new stock price (type 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                double newPrice = Double.parseDouble(input);
                stockMarket.setStockPrice(newPrice);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        scanner.close();
    }
}
