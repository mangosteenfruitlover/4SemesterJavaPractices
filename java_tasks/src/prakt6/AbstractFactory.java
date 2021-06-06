package prakt6;

public class AbstractFactory implements IAbstractFactory{
    @Override
    public IProduct createProduct(String name){
        return new Product(name);
    }

    @Override
    public IProduct createEmptyProduct(){
        return new Product("Empty");
    }
}
