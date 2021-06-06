package prakt5;

public class SingletonH{
    public static class SingletonHolder{
        public static final SingletonH HOLDER_INSTANCE=new SingletonH();
    }

    public static SingletonH getInstance(){
        return SingletonHolder.HOLDER_INSTANCE;
    }
}