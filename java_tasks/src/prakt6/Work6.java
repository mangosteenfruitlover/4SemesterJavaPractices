package prakt6;
public class Work6{
    public static void main(String[] args){
        //Factory method
        IProduct product;
        System.out.println("Test| Factory method:");
        IFactoryMethod factoryMethod=new FactoryMethod();
        product=factoryMethod.createProduct("Nokia");
        product.report();
        factoryMethod.setVersion(true);
        product=factoryMethod.createProduct("Iphone");
        product.report();
        //Abstract factory
        System.out.println("Test| Abstract factory:");
        IAbstractFactory factory=new AbstractFactory();
        product=factory.createProduct("Samsung");
        product.report();
        product=factory.createEmptyProduct();
        product.report();
        //Builder
        System.out.println("Test| Builder:");
        IBuilder builder;
        builder=new Builder();
        builder.build()
                .report();
        builder.setSystem("Apple")
                .setName("IPhone")
                .setPrice("1500$")
                .build()
                .report();
        //Prototype
        System.out.println("Test| Prototype:");
        IPrototype prototype;
        prototype=new PrototypeWithPrice(500);
        prototype.report();
        IPrototype clonedPrototype;
        clonedPrototype=prototype.cloneIt();
        clonedPrototype.report();
        prototype=new PrototypeWithName("Nokia");
        prototype.report();
        clonedPrototype=prototype.cloneIt();
        clonedPrototype.report();
    }
}
