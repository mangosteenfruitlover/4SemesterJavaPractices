package prakt6;

public class FactoryMethod implements IFactoryMethod{
    private boolean version=false;
    @Override
    public void setVersion(boolean version){
        this.version=version;
    }
    @Override
    public IProduct createProduct(String name){
        return version?new ProductWithLastVersion(name):new Product(name);
    }
}
