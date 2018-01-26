package product;

/**
 * Created by hatice.ozdemir on 28.12.2017.
 */
public abstract class Product {
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription( String description) {this.description = description;}
    public abstract double cost();
}
