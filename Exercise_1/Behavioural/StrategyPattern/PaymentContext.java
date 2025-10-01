package Exercise_1.Behavioural.StrategyPattern;

public class PaymentContext {
private PaymentStrategy strategy;
public PaymentContext(PaymentStrategy strategy) { this.strategy = strategy; }
public void setStrategy(PaymentStrategy strategy) { this.strategy = strategy; }
public void checkout(double amount) { strategy.pay(amount); }
}