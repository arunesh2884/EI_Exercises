package Exercise_1.Behavioural.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        PaymentContext ctx = new PaymentContext(new CreditCardStrategy("4111-1111-1111-1111"));
        ctx.checkout(49.99);
        // swap strategy at runtime
        ctx.setStrategy(new PayPalStrategy("user@example.com"));
        ctx.checkout(19.95);
    }
}