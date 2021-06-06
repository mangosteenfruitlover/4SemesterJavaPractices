package prakt6;

public class PrototypeWithPrice implements IPrototype{
    private int price;
    PrototypeWithPrice(int price){
        this.price=price;
    }
    @Override
    public IPrototype cloneIt(){
        return new PrototypeWithPrice(price);
    }
    @Override
    public void report(){
        System.out.println("PrototypeWithPrice: Price="
                         +price);
    }
}
