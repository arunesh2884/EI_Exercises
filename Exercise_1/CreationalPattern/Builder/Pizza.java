package Exercise_1.CreationalPattern.Builder;

public class Pizza {
    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean bacon;


    public Pizza(String size, boolean cheese, boolean pepperoni, boolean bacon) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.bacon = bacon;
    }


    @Override
    public String toString() {
        return "Pizza[size=" + size + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", bacon=" + bacon + "]";
    }
}