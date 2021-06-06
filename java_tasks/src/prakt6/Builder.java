package prakt6;

public class Builder implements IBuilder{
    private String name="Empty";
    private String system="Android";
    private String price="50";
    @Override
    public IBuilder setSystem(String system){
        this.system=system;
        return this;
    }
    @Override
    public IBuilder setPrice(String price){
        this.price=price;
        return this;
    }
    @Override
    public IBuilder setName(String name){
        this.name=name;
        return this;
    }
    @Override
    public IProduct build(){
        return new Product(system
                                   +" "
                                   +price
                                   +" "
                                   +name);
    }
}
