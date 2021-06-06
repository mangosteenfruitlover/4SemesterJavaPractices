package prakt6;

public interface IBuilder{
    IBuilder setSystem(String system);
    IBuilder setPrice(String size);
    IBuilder setName(String name);
    IProduct build();
}
