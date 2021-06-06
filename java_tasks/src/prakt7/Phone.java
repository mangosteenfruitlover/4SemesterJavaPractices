package prakt7;

public class Phone{
    private MyState myState;
    private final String name;
    private int price;
    public Phone(String name,int price,MyState externalState){
        this.name=name;
        this.price=price;
        this.myState=externalState;
    }
    void setPrice(int price){
        this.price=price;
    }
    void setMyState(MyState myState){
        this.myState=myState;
    }
    @Override
    public String toString(){
        return "Phone "
                +name
                +" ("
                +price
                +"$), version: "
                +myState.toString();
    }
}
