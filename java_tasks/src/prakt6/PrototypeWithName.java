package prakt6;

public class PrototypeWithName implements IPrototype{
    private String name;
    public PrototypeWithName(String name){
        this.name=name;
    }
    @Override
    public IPrototype cloneIt(){
        return new PrototypeWithName(name);
    }
    @Override
    public void report(){
        System.out.println("PrototypeWithName, name="
                                   +name);
    }
}
