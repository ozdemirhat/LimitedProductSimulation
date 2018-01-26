package product.combine;

import product.Product;
import product.ProductDecorator;

/**
 * Created by hatice.ozdemir on 28.12.2017.
 */
public class Shoe extends ProductDecorator {
    Product product;
    public Shoe(Product product){
        this.product=product;
    }
    public  String getDescription(){
        return product.getDescription()+", shoe";
    }
    public double cost()
    {
        return 4+product.cost();
    }
}
