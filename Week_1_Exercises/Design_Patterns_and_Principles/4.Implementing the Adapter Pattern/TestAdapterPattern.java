public class TestAdapterPattern {
    public static void main(String[] args) {
        // Using Gpay through the adapter
        Gpay gPay = new Gpay();
        PaymentProcessor gPayProcessor = new GpayAdapter(gPay);
        GpayProcessor.processPayment(100.00);

        // Using Stripe through the adapter
        Stripe stripe = new Stripe();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        stripeProcessor.processPayment(200.00);

        // Using Square through the adapter
        Square square = new Square();
        PaymentProcessor squareProcessor = new SquareAdapter(square);
        squareProcessor.processPayment(300.00);
    }
}
