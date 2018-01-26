package product;

/**
 * Created by hatice.ozdemir on 28.12.2017.
 */
public abstract class Product {
    Integer id;
    String description;
    public String getDescription() {
        return description;
    }
    public abstract double cost();
}
