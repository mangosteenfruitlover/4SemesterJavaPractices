package prakt6;

public class Product implements IProduct{
    private String name;
    public Product(String name){
        this.name=name;
    }
    @Override
    public void report(){
        System.out.println("Product "
                                   +name);
    }
}
