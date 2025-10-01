package Exercise_1.CreationalPattern.Builder;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .size("Large")
                .cheese(true)
                .pepperoni(true)
                .bacon(false)
                .build();
        System.out.println(pizza);
    }
}
