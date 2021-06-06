package prakt7;

import java.util.ArrayList;
import java.util.List;

public class Figure implements IPrimitive{
    private List<IPrimitive> primitives=new ArrayList<>();
    Figure add(IPrimitive primitive){
        primitives.add(primitive);
        return this;
    }
    Figure remove(IPrimitive primitive){
        primitives.remove(primitive);
        return this;
    }
    @Override
    public void setColor(String color){
        primitives.forEach((primitive)->primitive.setColor(color));
    }
    @Override
    public String toString(){
        return "Figure("+primitives+')';
    }
}
