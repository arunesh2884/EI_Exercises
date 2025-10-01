package Exercise_1.CreationalPattern.Builder;

public class PizzaBuilder {
    private String size = "medium";
    private boolean cheese = false;
    private boolean pepperoni = false;
    private boolean bacon = false;


    public PizzaBuilder size(String size) { 
        this.size = size; return this; 
    }
    public PizzaBuilder cheese(boolean c) { 
        this.cheese = c;
        return this;
    }
    public PizzaBuilder pepperoni(boolean p) { 
        this.pepperoni = p; 
        return this; 
    }
    public PizzaBuilder bacon(boolean b) { 
        this.bacon = b; 
        return this; 
    }
    public Pizza build() { 
        return new Pizza(size, cheese, pepperoni, bacon); 
    }
}