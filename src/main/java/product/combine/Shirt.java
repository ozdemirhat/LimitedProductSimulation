package product.combine;

import product.Product;
import product.ProductDecorator;

/**
 * Created by hatice.ozdemir on 28.12.2017.
 */
public class Shirt extends ProductDecorator {
    Product product;
    public Shirt(Product product){
        this.product=product;
    }
    public  String getDescription(){
        return product.getDescription()+", shirt";
    }
    public double cost()
    {
        return 4+product.cost();
    }
}
