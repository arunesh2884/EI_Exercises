package Exercise_1.Behavioural.StrategyPattern;

public class PayPalStrategy implements PaymentStrategy {
private final String email;
public PayPalStrategy(String email) { this.email = email; }
@Override
public void pay(double amount) {
System.out.println("Paid " + amount + " using PayPal: " + email);
}
}