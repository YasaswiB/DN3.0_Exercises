import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext paymentContext = new PaymentContext();

        System.out.println("Select payment method: ");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        PaymentStrategy paymentStrategy = null;

        switch (choice) {
            case 1:
                // Credit Card Payment
                System.out.print("Enter credit card number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter cardholder's name: ");
                String name = scanner.nextLine();
                paymentStrategy = new CreditCardPayment(cardNumber, name);
                break;

            case 2:
                // PayPal Payment
                System.out.print("Enter PayPal email: ");
                String email = scanner.nextLine();
                paymentStrategy = new PayPalPayment(email);
                break;

            default:
                System.out.println("Invalid choice");
                return;
        }

        paymentContext.setPaymentStrategy(paymentStrategy);

        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();

        paymentContext.executePayment(amount);
    }
}
