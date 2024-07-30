// StrategyPatternDemo.java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        // Create payment strategies
        PaymentStrategy creditCardPayment = new CreditCardPayment("John Doe", "1234-5678-9876-5432");
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");

        // Create context with CreditCardPayment strategy
        PaymentContext context = new PaymentContext(creditCardPayment);
        context.executePayment(100);

        // Switch to PayPalPayment strategy
        context = new PaymentContext(payPalPayment);
        context.executePayment(200);
    }
}
