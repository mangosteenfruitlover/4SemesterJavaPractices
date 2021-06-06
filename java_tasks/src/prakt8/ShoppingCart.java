package prakt8;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    void addProduct(Product product) {
        products.add(product);
    }
    public void apply(IVisitor visitor) {
        products.forEach(visitor::visit);
    }
}
