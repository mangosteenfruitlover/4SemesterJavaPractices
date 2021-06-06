package prakt5;

public class SingletonI{
    private static SingletonI instance;

    public static synchronized SingletonI getInstance(){
        if(instance==null){
            instance=new SingletonI();
        }
        return instance;
    }
}