package prakt5;

public class Work5{
    public static void main(String[] args){
        SingletonEnum singletonEnum1=SingletonEnum.getInstance();
        SingletonH singletonH1=SingletonH.getInstance();
        SingletonI singletonI1=SingletonI.getInstance();
        SingletonEnum singletonEnum2=SingletonEnum.getInstance();
        SingletonH singletonH2=SingletonH.getInstance();
        SingletonI singletonI2=SingletonI.getInstance();
        System.out.println(singletonEnum1);
        System.out.println(singletonEnum2);
        System.out.println(singletonH1);
        System.out.println(singletonH2);
        System.out.println(singletonI1);
        System.out.println(singletonI2);
    }
}
