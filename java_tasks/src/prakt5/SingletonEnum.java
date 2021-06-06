package prakt5;

public enum SingletonEnum{
    INSTANCE;

    static SingletonEnum getInstance(){
        return INSTANCE;
    }
}
