public class GpayAdapter implements PaymentProcessor {
    private Gpay gPay;

    public GpayAdapter(Gpay Gpay) {
        this.gPay = gPay;
    }

    @Override
    public void processPayment(double amount) {
        gPay.sendPayment(amount);
    }
}

