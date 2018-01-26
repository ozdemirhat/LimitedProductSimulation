package product.combine;

import product.Product;
import product.ProductDecorator;

/**
 * Created by hatice.ozdemir on 28.12.2017.
 */
public class Skirt extends ProductDecorator {
    Product product;
    public Skirt(Product product){
        this.product=product;
    }
    public  String getDescription(){
        return product.getDescription()+", skirt";
    }
    public double cost()
    {
        return 4+product.cost();
    }
}
