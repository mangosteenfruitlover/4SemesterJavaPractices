package prakt6;

public interface IFactoryMethod{
    void setVersion(boolean version);
    IProduct createProduct(String name);
}
