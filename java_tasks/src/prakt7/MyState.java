package prakt7;

public class MyState{
    private String version;
    public MyState(String version){
        this.version=version;
    }
    @Override
    public String toString(){
        return version;
    }
}
