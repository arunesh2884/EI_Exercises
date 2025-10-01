package Exercise_1.Behavioural.StrategyPattern;

public class CreditCardStrategy implements PaymentStrategy {
    private final String cardNumber;
    public CreditCardStrategy(String cardNumber) { this.cardNumber = cardNumber; }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}