package prakt7;

public class PrimitiveDot implements IPrimitive{
    private String color;
    @Override
    public void setColor(String color){
        this.color=color;
    }
    @Override
    public String toString(){
        return color+" dot";
    }
}
