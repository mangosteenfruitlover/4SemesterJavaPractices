package prakt6;

public interface IAbstractFactory{
    IProduct createProduct(String name);
    IProduct createEmptyProduct();
}
