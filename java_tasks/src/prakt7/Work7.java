package prakt7;

public class Work7{
    public static void main(String[] args){
        System.out.println("Flyweight");
        MyState newState=new MyState("7");
        MyState oldState=new MyState("3310");
        Phone iphone=new Phone("Iphone",1500,newState);
        Phone samsung=new Phone("Samsung",400,newState);
        Phone nokia=new Phone("Nokia",600,oldState);
        System.out.println(iphone.toString());
        System.out.println(samsung.toString());
        System.out.println(nokia.toString());
        iphone.setMyState(oldState);
        iphone.setPrice(600);
        samsung.setMyState(oldState);
        samsung.setPrice(1100);
        nokia.setPrice(50);
        System.out.println(iphone.toString());
        System.out.println(samsung.toString());
        System.out.println(nokia.toString());
        System.out.println("Composite");
        Figure scene=new Figure();
        Figure face=new Figure()
                .add(new PrimitiveDot())
                .add(new PrimitiveLine())
                .add(new PrimitiveDot());
        Figure house=new Figure()
                .add(new PrimitiveLine())
                .add(new PrimitiveLine());
        scene.add(face).add(house);
        scene.setColor("green");
        System.out.println(scene.toString());
        scene.remove(face);
        scene.setColor("red");
        System.out.println(scene.toString());
    }
}
