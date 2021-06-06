package prakt3;

public class Work3{
    public static void main(String[] args){
        SetSemaphore<Boolean> setSemaphore=new SetSemaphore<>();
        setSemaphore.add(true);
        setSemaphore.add(false);
        setSemaphore.add(true);
        System.out.println("setSemaphore:");
        System.out.println(setSemaphore);

        SynchronizedMap<String,String> synchronizedMap=new SynchronizedMap<>();
        synchronizedMap.put("aKey","1Value");
        synchronizedMap.put("bKey","2Value");
        synchronizedMap.put("cKey","3Value");
        System.out.println("SynchronizedMap:");
        System.out.println(synchronizedMap);
    }
}
