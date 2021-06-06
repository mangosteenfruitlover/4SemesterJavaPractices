package prakt8;

public class Work8{
    public static void main(String[] args) {
        System.out.println("Visitor");
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product(10));
        cart.addProduct(new Product(20));
        cart.addProduct(new Product(5));
        Summator summator = new Summator();
        cart.apply(summator);
        System.out.println("Total: "+summator.getTotal());
        System.out.println("Command");
        Product cheapProduct = new Product(100);
        System.out.println("Product price: "+cheapProduct.getPrice());
        IProductCommand command = new IncreasePriceCommand(20);
        command.execute(cheapProduct);
        System.out.println("Increased product price: "+cheapProduct.getPrice());
    }

}
